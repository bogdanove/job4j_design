package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;


class ReportProgrammerTest {

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder()
                .append("Name: ").append(worker.getName()).append(";")
                .append(System.lineSeparator())
                .append("Hired: ").append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(System.lineSeparator())
                .append("Fired: ").append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(System.lineSeparator())
                .append("Salary: ").append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}