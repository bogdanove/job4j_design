package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportAccountant implements Report {

    private double rate;
    private String currency;
    private Store store;

    public ReportAccountant(Store store, double rate, String currency) {
        this.currency = currency;
        this.rate = rate;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(Utils.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(Utils.DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(Utils.DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * rate).append(currency).append(";")
                    .append(Utils.SEPARATOR);
        }
        return text.toString();
    }
}
