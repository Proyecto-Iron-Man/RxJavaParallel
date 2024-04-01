package pe.ironman.parallel.data.clientapi.studentcourses.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiStudentCourse {
    private Long courseId;
    private String courseName;
    private Integer courseCredits;
    private Integer courseDuration;
    private Long studentId;
    private String apiWarningMessage;
}
