package ru.job4j.design.ocp;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import ru.job4j.design.srp.*;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
class ReportXMLTest {

    @Test
    void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(Utils.SEPARATOR)
                .append("<employees>").append(Utils.SEPARATOR)
                .append("<employees>").append(Utils.SEPARATOR)
                .append("<fired>").append(Utils.DATE_FORMAT.format(worker.getFired().getTime())).append("</fired>").append(Utils.SEPARATOR)
                .append("<hired>").append(Utils.DATE_FORMAT.format(worker.getHired().getTime())).append("</hired>").append(Utils.SEPARATOR)
                .append("<name>").append(worker.getName()).append("</name>").append(Utils.SEPARATOR)
                .append("<salary>").append(worker.getSalary()).append("</salary>").append(Utils.SEPARATOR)
                .append("</employees>").append(Utils.SEPARATOR)
                .append("</employees>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}