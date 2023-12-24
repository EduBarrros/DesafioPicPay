package com.desafioPicPay.domain.user;

import com.desafioPicPay.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO user){
        this.balance = user.balance();
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.document = user.document();
        this.password = user.password();
        this.userType = user.userType();
        this.email = user.email();
    }
}
