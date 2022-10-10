package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;

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
                .append("\"name\":").append("\"")
                .append(worker.getName()).append("\"").append(",")
                .append("\"hired\":").append("{")
                .append("\"year\":").append(worker.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(Calendar.SECOND))
                .append("}").append(",")
                .append("\"fired\":").append("{")
                .append("\"year\":").append(worker.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(Calendar.SECOND))
                .append("}").append(",")
                .append("\"salary\":").append(worker.getSalary())
                .append("}]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}