package org.ssupstart.streams.basicstreamcode.collection;

import org.ssupstart.ems.dtos.EmployeeDto;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamApi {
    public static void main(String[] args) {
        List<EmployeeDto> employees = Arrays.asList(
                new EmployeeDto(1, "John", "Engineering", 75000),
                new EmployeeDto(2, "Alice", "HR", 50000),
                new EmployeeDto(3, "Bob", "Engineering", 80000),
                new EmployeeDto(4, "David", "Finance", 90000),
                new EmployeeDto(5, "Eve", "HR", 60000)
        );

        //filter with HR department
        List<EmployeeDto> hrDeptList = getEmployeeOfHrDept(employees);
        System.out.println("hrDept " + hrDeptList);

        //get list of employee names only
        List<String> employeeNames = getEmployeeNames(employees);
        System.out.println("empNames " + employeeNames);

        //sort employees on basis of salary
        List<EmployeeDto> sortedDesc = sortEmployeesOnSalary(employees);
        System.out.println("sortedDesc " + sortedDesc);

        //Calculate total salary
        Double totalSalary = calculateTotalSalary(employees);
        System.out.println("totalSal " + totalSalary);

        //Distinct Department
        List<String> distDept = getDistinctDepartment(employees);
        System.out.println(distDept);

        //Get First n employees
        List<EmployeeDto> firstThreeEmp = getFirstThreeEmp(employees, 3);
        System.out.println(firstThreeEmp);

        //Any employees earn more than 80k
        List<EmployeeDto> moreThanEighty = getEmployeeMoreThanEightyK(employees);
        System.out.println(moreThanEighty);

        //Employee List By Departments
        Map<String,List<EmployeeDto>> departMentEmployeeMap = getEmployeesByDepartment(employees);
        for (Map.Entry<String,List<EmployeeDto>> entry : departMentEmployeeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    private static Map<String, List<EmployeeDto>> getEmployeesByDepartment(List<EmployeeDto> employees) {
        return employees.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment));
    }

    private static List<EmployeeDto> getEmployeeMoreThanEightyK(List<EmployeeDto> employees) {
        if(employees.stream().anyMatch(e -> e.getSalary() > 80000)){
            return employees.stream().filter(e -> e.getSalary()>80000).toList();
        }
        else
            return new ArrayList<>();
    }

    private static List<EmployeeDto> getFirstThreeEmp(List<EmployeeDto> employees, int limit) {
        if(limit > employees.size())
            return employees;
        else
            return employees.stream().limit(3).toList();
    }

    private static List<String> getDistinctDepartment(List<EmployeeDto> employees) {
        return employees.stream().map(EmployeeDto::getDepartment).distinct().toList();
    }

    private static Double calculateTotalSalary(List<EmployeeDto> employees) {
        return employees.stream().mapToDouble(EmployeeDto::getSalary).sum();
    }

    private static List<EmployeeDto> sortEmployeesOnSalary(List<EmployeeDto> employees) {
        return employees.stream().sorted(Comparator.comparing(EmployeeDto::getSalary).reversed()).toList();
    }

    private static List<String> getEmployeeNames(List<EmployeeDto> employees) {
        return employees.stream().map(EmployeeDto::getName).toList();
    }

    private static List<EmployeeDto> getEmployeeOfHrDept(List<EmployeeDto> employees) {
        return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).toList();
    }
}
