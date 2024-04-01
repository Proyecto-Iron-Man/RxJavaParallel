package pe.ironman.parallel.expose.web;

import io.reactivex.rxjava3.core.Maybe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ironman.parallel.application.dtos.StudentCourseDto;
import pe.ironman.parallel.application.services.SequentialStudentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("sequential-students")
public class SequentialStudentController {
    private final SequentialStudentService sequentialStudentService;

    @GetMapping("{documentNumber}")
    public Maybe<StudentCourseDto> getSequentialStudentCourses(@PathVariable("documentNumber") String documentNumber) {
        return sequentialStudentService.getSequentialStudentCourses(documentNumber);
    }
}
