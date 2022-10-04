package ru.job4j.design.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.design.ocp.ReportJson;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.MemStore;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Utils;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportJsonTest {


    @Test
    void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 199.99);
        store.add(worker);
        Report engine = new ReportJson(store);
        StringBuilder expect = new StringBuilder()
                .append("[{")
                .append("\"fired\":").append("\"")
                .append(Utils.DATE_FORMAT.format(worker.getFired().getTime()))
                .append("\"").append(",")
                .append("\"name\":").append("\"")
                .append(worker.getName())
                .append("\"").append(",")
                .append("\"hired\":").append("\"")
                .append(Utils.DATE_FORMAT.format(worker.getHired().getTime()))
                .append("\"").append(",")
                .append("\"salary\":").append(worker.getSalary())
                .append("}]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}