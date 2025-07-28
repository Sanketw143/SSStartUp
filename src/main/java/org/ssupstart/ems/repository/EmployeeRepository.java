package org.ssupstart.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssupstart.ems.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Employee getEmployeeByMobileNumber(Integer mobileNumber);
}
