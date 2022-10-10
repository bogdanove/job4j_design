package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {


    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML>").append(Utils.SEPARATOR)
                .append("<html>").append(Utils.SEPARATOR)
                .append("<head>").append(Utils.SEPARATOR)
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">").append(Utils.SEPARATOR)
                .append("<title>Report emploees</title>").append(Utils.SEPARATOR)
                .append("</head>").append(Utils.SEPARATOR)
                .append("<body>").append(Utils.SEPARATOR)
                .append("<table>").append(Utils.SEPARATOR)
                .append("<tr>").append(Utils.SEPARATOR)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>").append(Utils.SEPARATOR)
                .append("</tr>").append(Utils.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(Utils.SEPARATOR)
                    .append("<td>").append(employee.getName()).append(";").append("</td>")
                    .append("<td>").append(Utils.DATE_FORMAT.format(employee.getHired().getTime())).append("</td>")
                    .append("<td>").append(Utils.DATE_FORMAT.format(employee.getFired().getTime())).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>")
                    .append(Utils.SEPARATOR);
        }
        text.append("</table>").append(Utils.SEPARATOR)
                .append("</body>").append(Utils.SEPARATOR)
                .append("</html>").append(Utils.SEPARATOR);
        return text.toString();
    }
}
