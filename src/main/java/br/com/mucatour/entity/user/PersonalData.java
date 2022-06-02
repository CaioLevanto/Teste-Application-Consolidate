package br.com.mucatour.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Column(name = "number_cpf", nullable = false, unique = false)
    private Integer cpf;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NumberFormat
    @Column(name = "number_passport", unique = false)
    private Integer numberPassport;

    @NumberFormat
    @Column(name = "driver_license", nullable = true)
    private Integer driversLicense;

}
