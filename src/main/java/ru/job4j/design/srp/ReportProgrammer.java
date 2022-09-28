package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("Name: ").append(employee.getName()).append(";")
                    .append(System.lineSeparator())
                    .append("Hired: ").append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(System.lineSeparator())
                    .append("Fired: ").append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(System.lineSeparator())
                    .append("Salary: ").append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
