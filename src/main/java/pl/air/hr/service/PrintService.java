package pl.air.hr.service;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrintService {

    public static String print(Department one) {
        Integer id = one.getId();
        String name = one.getName();
        String location = one.getLocation();

        String printout = String.format("%s (id = %d), %s", name, id, location);
        return printout;
    }

    public static String print(Employee one) {
        Integer id = one.getId();
        String firstName = one.getFirstName();
        String lastName = one.getLastName();
        BigDecimal salary = one.getSalary();
        BigDecimal allowance = one.getAllowance();
        LocalDate hireDate = one.getHireDate();

        String printout =
                String.format("%s %s (id = %d) \n", firstName, lastName, id) +
                String.format(" - wynagrodzenie: %.2f zł \n", salary) +
                " - dodatek: " + ( (allowance != null) ? String.format("%.2f zł", allowance) : "---" ) + "\n" +
                String.format(" - data zatrudnienia: %tF", hireDate);
        return printout;
    }

}
