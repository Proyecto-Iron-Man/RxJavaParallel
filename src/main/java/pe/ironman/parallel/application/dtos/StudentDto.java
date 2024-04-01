package pe.ironman.parallel.application.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String documentNumber;
    private String name;
    private String email;
    private String careerName;
    private Integer careerCredits;
    private Integer percentageCompleted;
    private String apiCareerWarningMessage;
}
