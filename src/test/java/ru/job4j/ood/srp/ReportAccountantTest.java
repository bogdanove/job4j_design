package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportAccountantTest {

    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAccountant(store, 0.6, "$");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(Utils.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(Utils.DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(Utils.DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * 0.6).append("$").append(";")
                .append(Utils.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}