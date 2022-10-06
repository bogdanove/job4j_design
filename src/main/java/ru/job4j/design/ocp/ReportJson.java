package ru.job4j.design.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Store;

import java.util.function.Predicate;

public class ReportJson implements Report {

    private Store store;

    private GsonBuilder builder;

    private Gson jsonreport;

    public ReportJson(Store store) {
        this.store = store;
        builder = new GsonBuilder();
        jsonreport = builder.create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return jsonreport.toJson(store.findBy(filter));
    }
}
