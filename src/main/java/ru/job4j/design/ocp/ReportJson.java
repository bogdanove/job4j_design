package ru.job4j.design.ocp;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Store;
import ru.job4j.design.srp.Utils;

import java.util.function.Predicate;

public class ReportJson implements Report {

    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var jsonreport = new JSONArray();
        for (Employee employee : store.findBy(filter)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", employee.getName());
            jsonObject.put("hired", Utils.DATE_FORMAT.format(employee.getHired().getTime()));
            jsonObject.put("fired", Utils.DATE_FORMAT.format(employee.getFired().getTime()));
            jsonObject.put("salary", employee.getSalary());
            jsonreport.put(jsonObject);
        }
        return jsonreport.toString();
    }
}
