package pe.ironman.parallel.data.clientapi.studentcourses.services.impl;

import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ironman.parallel.data.clientapi.studentcourses.models.ApiStudentCourse;
import pe.ironman.parallel.data.clientapi.studentcourses.services.ApiStudentCourseService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ApiStudentCourseServiceImpl implements ApiStudentCourseService {
    @Override
    public Flowable<ApiStudentCourse> getStudentCoursesByStudentId(Long studentId) {
        if(222 == studentId) {
            return Flowable.empty();
        }

        if(2222 == studentId) {
            return Flowable.error(new RuntimeException("Error"));
        }


        return Flowable.fromIterable(getStudentCourses(studentId))
                .doOnNext(item -> log.info("getStudentCoursesByStudentId executed on thread: " + Thread.currentThread().getName()))
                .delay(1, TimeUnit.SECONDS)
                ;
    }

    private List<ApiStudentCourse> getStudentCourses(Long studentId) {
        return List.of(
                ApiStudentCourse.builder()
                        .courseId(1L)
                        .studentId(studentId)
                        .courseName("Math")
                        .courseCredits(5)
                        .courseDuration(40)
                        .build(),
                ApiStudentCourse.builder()
                        .courseId(2L)
                        .studentId(studentId)
                        .courseName("Science")
                        .courseCredits(4)
                        .courseDuration(36)
                        .build(),
                ApiStudentCourse.builder()
                        .courseId(3L)
                        .studentId(studentId)
                        .courseName("English")
                        .courseCredits(3)
                        .courseDuration(32)
                        .build()
        );
    }

}
