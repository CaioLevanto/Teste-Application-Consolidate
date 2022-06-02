package br.com.mucatour.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private Integer numberPhone;

    @OneToOne
    private PersonalData personalData;

    @OneToOne
    private Address address;

    public User withCreate(User user) {
        return withCreate(user, null);
    }

    public User withCreate(User user, Long id) {
        return new User(
                (id != null ? id : this.id), 
                user.getFirstName(), 
                user.getLastName(), 
                user.getEmail(), 
                new BCryptPasswordEncoder().encode(user.getPassword()), 
                0000000, 
                new PersonalData(
                        this.personalData.getId(),
                        user.getPersonalData().getCpf(),
                        user.getPersonalData().getBirthDate(),
                        user.getPersonalData().getNumberPassport(),
                        user.getPersonalData().getDriversLicense()
                ), new Address(
                        this.address.getId(),
                        user.getAddress().getCep(),
                        user.getAddress().getCountry(),
                        user.getAddress().getState(),
                        user.getAddress().getCounty(),
                        user.getAddress().getAddressName(),
                        user.getAddress().getNumberAddress()
                ));
    }

    public User withUpdate(Long id, User newUser) {
        return withCreate(newUser, id);
    }

}
