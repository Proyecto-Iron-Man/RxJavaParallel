package pe.ironman.parallel.application.services.impl;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.ironman.parallel.application.dtos.CourseDto;
import pe.ironman.parallel.application.dtos.StudentCourseDto;
import pe.ironman.parallel.application.dtos.StudentDto;
import pe.ironman.parallel.application.services.ParallelStudentService;
import pe.ironman.parallel.data.clientapi.studentcareers.models.ApiStudentCareer;
import pe.ironman.parallel.data.clientapi.studentcareers.services.ApiStudentCareerService;
import pe.ironman.parallel.data.clientapi.studentcourses.models.ApiStudentCourse;
import pe.ironman.parallel.data.clientapi.studentcourses.services.ApiStudentCourseService;
import pe.ironman.parallel.data.clientapi.students.models.ApiStudent;
import pe.ironman.parallel.data.clientapi.students.services.ApiStudentService;

import java.util.List;

import static io.reactivex.rxjava3.schedulers.Schedulers.io;
import static pe.ironman.parallel.utils.Constant.*;

@RequiredArgsConstructor
@Service
public class ParallelStudentServiceImpl implements ParallelStudentService {
    private final ApiStudentService apiStudentService;
    private final ApiStudentCareerService apiStudentCareerService;
    private final ApiStudentCourseService apiStudentCourseService;


    @Override
    public Maybe<StudentCourseDto> getParallelStudentCourses(String documentNumber) {
        return apiStudentService.getStudentByDocumentNumber(documentNumber)
                .flatMap(this::getStudentCourseObservable)
                .firstElement();
    }

    private Observable<StudentCourseDto> getStudentCourseObservable(ApiStudent apiStudent) {
        var prepareApiStudentCareer = apiStudentCareerService
                .getStudentCareerByStudentId(apiStudent.getId())
                .onErrorReturnItem(API_STUDENT_CAREER_DEFAULT_WHEN_ERROR)
                .switchIfEmpty(Observable.just(API_STUDENT_CAREER_DEFAULT))
                .subscribeOn(io())
                ;

        var prepareApiStudentCourse = apiStudentCourseService
                .getStudentCoursesByStudentId(apiStudent.getId())
                .onErrorReturnItem(API_STUDENT_COURSE_DEFAULT_WHEN_ERROR)
                .toList()
                .toObservable()
                .subscribeOn(io())
                ;

        return Observable.zip(prepareApiStudentCareer, prepareApiStudentCourse, (apiStudentCareer, apiStudentCourses)
                -> getStudentCourse(apiStudent, apiStudentCareer, apiStudentCourses));
    }

    private static StudentCourseDto getStudentCourse(
            ApiStudent apiStudent, ApiStudentCareer apiStudentCareer, List<ApiStudentCourse> apiStudentCourses) {
        var student = StudentDto.builder()
                .documentNumber(apiStudent.getDocumentNumber())
                .name(apiStudent.getName())
                .email(apiStudent.getEmail())
                .careerName(apiStudentCareer.getCareerName())
                .careerCredits(apiStudentCareer.getCareerCredits())
                .percentageCompleted(apiStudentCareer.getPercentageCompleted())
                .apiCareerWarningMessage(apiStudentCareer.getApiWarningMessage())
                .build();

        var courses = apiStudentCourses.stream()
                .map(apiStudentCourse -> CourseDto.builder()
                        .name(apiStudentCourse.getCourseName())
                        .credits(apiStudentCourse.getCourseCredits())
                        .duration(apiStudentCourse.getCourseDuration())
                        .apiCourseWarningMessage(apiStudentCourse.getApiWarningMessage())
                        .build())
                .toList();

        return StudentCourseDto.builder()
                .student(student)
                .courses(courses)
                .build();
    }
}
