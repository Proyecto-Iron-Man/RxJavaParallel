package pe.ironman.parallel.data.clientapi.students.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiStudent {
    private Long id;
    private String documentNumber;
    private String name;
    private String email;
    private String phone;
    private String address;

}
