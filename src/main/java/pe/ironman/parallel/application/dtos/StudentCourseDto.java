package pe.ironman.parallel.application.dtos;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseDto {
    private StudentDto student;
    private List<CourseDto> courses;
}
