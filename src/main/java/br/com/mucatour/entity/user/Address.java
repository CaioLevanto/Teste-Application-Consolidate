package br.com.mucatour.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Column(nullable = false)
    private Integer cep;

    @Column(name = "country_name", nullable = false)
    private String country;

    @Column(name = "state_name", nullable = false)
    private String state;

    @Column(name = "county_name", nullable = false)
    private String county;

    @Column(name = "address_name", nullable = false)
    private String addressName;

    @Column(name = "number_address", nullable = false)
    private Long numberAddress;

}
