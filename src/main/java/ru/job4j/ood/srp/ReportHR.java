package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportHR implements Report {

    private Store store;

    private Comparator comparator;

    public ReportHR(Store store, Comparator comparator) {
        this.comparator = comparator;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(Utils.SEPARATOR);
        var list = store.findBy(filter);
        list.sort(comparator);
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(Utils.SEPARATOR);
        }
        return text.toString();
    }
}
