package pe.ironman.parallel.application.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String name;
    private Integer credits;
    private Integer duration;
    private String apiCourseWarningMessage;
}
