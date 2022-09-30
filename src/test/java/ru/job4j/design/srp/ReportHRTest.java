package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class ReportHRTest {

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Vadim", now, now, 90);
        store.add(worker1);
        store.add(worker);
        Report engine = new ReportHR(store, Comparator.comparing(Employee::getSalary).reversed());
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(Utils.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(Utils.SEPARATOR)
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(Utils.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}