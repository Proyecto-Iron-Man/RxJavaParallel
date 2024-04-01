package pe.ironman.parallel.application.services;

import io.reactivex.rxjava3.core.Maybe;
import pe.ironman.parallel.application.dtos.StudentCourseDto;

public interface SequentialStudentService {
    Maybe<StudentCourseDto> getSequentialStudentCourses(String documentNumber);
}
