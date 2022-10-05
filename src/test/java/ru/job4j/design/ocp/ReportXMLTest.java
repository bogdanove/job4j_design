package ru.job4j.design.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.design.srp.*;
import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.assertThat;
class ReportXMLTest {
    @Test
    void whenXmlGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append("<employees>")
                .append("<fired>").append(formatter.format(worker.getFired().getTime())).append("</fired>")
                .append("<hired>").append(formatter.format(worker.getHired().getTime())).append("</hired>")
                .append("<name>").append(worker.getName()).append("</name>")
                .append("<salary>").append(worker.getSalary()).append("</salary>")
                .append("</employees>")
                .append("</employees>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}