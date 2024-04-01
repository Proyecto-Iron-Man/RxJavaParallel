package pe.ironman.parallel.application.services;

import io.reactivex.rxjava3.core.Maybe;
import pe.ironman.parallel.application.dtos.StudentCourseDto;

public interface ParallelStudentService {
    Maybe<StudentCourseDto> getParallelStudentCourses(String documentNumber);
}
