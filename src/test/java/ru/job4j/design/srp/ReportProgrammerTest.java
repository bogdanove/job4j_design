package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;


class ReportProgrammerTest {

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE HTML>").append(Utils.SEPARATOR)
                .append("<html>").append(Utils.SEPARATOR)
                .append("<head>").append(Utils.SEPARATOR)
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">").append(Utils.SEPARATOR)
                .append("<title>Report emploees</title>").append(Utils.SEPARATOR)
                .append("</head>").append(Utils.SEPARATOR)
                .append("<body>").append(Utils.SEPARATOR)
                .append("<table>").append(Utils.SEPARATOR)
                .append("<tr>").append(Utils.SEPARATOR)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>").append(Utils.SEPARATOR)
                .append("</tr>").append(Utils.SEPARATOR)
                .append("<tr>").append(Utils.SEPARATOR)
                .append("<td>").append(worker.getName()).append(";").append("</td>")
                .append("<td>").append(Utils.DATE_FORMAT.format(worker.getHired().getTime())).append("</td>")
                .append("<td>").append(Utils.DATE_FORMAT.format(worker.getFired().getTime())).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td>")
                .append("</tr>")
                .append(Utils.SEPARATOR)
                .append("</table>").append(Utils.SEPARATOR)
                .append("</body>").append(Utils.SEPARATOR)
                .append("</html>").append(Utils.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}