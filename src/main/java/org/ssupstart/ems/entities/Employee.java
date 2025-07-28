package org.ssupstart.ems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@Data                   // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor      // Generates a no-args constructor
@AllArgsConstructor     // Generates an all-args constructor
@Builder                // Enables builder pattern //ToDo Read about this
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ToDo Read about this
    private Long id;

    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNo;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
}
