package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public ReportXML(Store store) throws JAXBException {
        this.store = store;
        context = JAXBContext.newInstance(Employees.class);
        marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            xml = writer.getBuffer().toString();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
