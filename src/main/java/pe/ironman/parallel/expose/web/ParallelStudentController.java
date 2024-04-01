package pe.ironman.parallel.expose.web;

import io.reactivex.rxjava3.core.Maybe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ironman.parallel.application.dtos.StudentCourseDto;
import pe.ironman.parallel.application.services.ParallelStudentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("parallel-students")
public class ParallelStudentController {

    private final ParallelStudentService parallelStudentService;

    @GetMapping("{documentNumber}")
    public Maybe<StudentCourseDto> getParallelStudentCourses(@PathVariable("documentNumber") String documentNumber) {
        return parallelStudentService.getParallelStudentCourses(documentNumber);
    }

}
