package org.ssupstart.streams.basicstreamcode.collection;

import org.ssupstart.ems.dtos.EmployeeDto;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamApiV2 {
    public static void main(String[] args) {
        List<EmployeeDto> employees = Arrays.asList(
                new EmployeeDto(1, "John", "Engineering", 75000),
                new EmployeeDto(2, "Alice", "HR", 50000),
                new EmployeeDto(3, "Bob", "Engineering", 80000),
                new EmployeeDto(4, "David", "Finance", 90000),
                new EmployeeDto(5, "Eve", "HR", 60000)
        );

        //filter with HR department
        List<EmployeeDto> hr = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).toList();
        System.out.println("hr " + hr);

        //get list of employee names only
        List<String> empNames = employees.stream().map(EmployeeDto :: getName).toList();
        System.out.println("names " + empNames);

        //sort employees on basis of salary
        List<EmployeeDto> sorted = employees.stream().sorted(Comparator.comparing(EmployeeDto::getSalary).reversed()).toList();
        System.out.println("sorted " + sorted);

        //Calculate total salary
        double totalSal = employees.stream().mapToDouble(EmployeeDto::getSalary).sum();
        System.out.println("sum " + totalSal);

        //Distinct Department
        Set<String> dept = employees.stream().map(EmployeeDto::getDepartment).collect(Collectors.toSet());
        System.out.println("dept set " + dept);
        List<String> deptV2 = employees.stream().map(EmployeeDto::getDepartment).distinct().toList();
        System.out.println("dept list " + deptV2);

        //Get First n employees
        List<EmployeeDto> firstNEmp = employees.stream().limit(3).toList();
        System.out.println("limit " + firstNEmp);

        //Any employees earn more than 80k
        boolean eighty = employees.stream().anyMatch(e -> e.getSalary() > 95000);
        System.out.println("eighty " + eighty);

        //Employee List By Departments
        Map<String,List<EmployeeDto>> emp = employees.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment));

    }
}
