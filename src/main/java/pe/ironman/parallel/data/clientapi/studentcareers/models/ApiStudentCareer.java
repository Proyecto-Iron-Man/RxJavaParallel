package pe.ironman.parallel.data.clientapi.studentcareers.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiStudentCareer {
    private Long careerId;
    private String careerName;
    private Integer careerCredits;
    private Integer percentageCompleted;
    private Long studentId;
    private String apiWarningMessage;
}
