package org.ssupstart.ems.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssupstart.ems.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getByEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email address") String email);

    Employee getByUsername(@NotBlank(message = "Username is required") String userName);
}
