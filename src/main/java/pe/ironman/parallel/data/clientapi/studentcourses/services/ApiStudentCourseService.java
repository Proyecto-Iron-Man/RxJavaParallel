package pe.ironman.parallel.data.clientapi.studentcourses.services;

import io.reactivex.rxjava3.core.Flowable;
import pe.ironman.parallel.data.clientapi.studentcourses.models.ApiStudentCourse;

public interface ApiStudentCourseService {
    Flowable<ApiStudentCourse> getStudentCoursesByStudentId(Long studentId);
}
