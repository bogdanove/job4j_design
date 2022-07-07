package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainXML {
    public static void main(String[] args) throws Exception {
        StudentXML student = new StudentXML(false, 30, "Igor", new FacultyXML("MBA"),
                new String[] {"Business", "Marketing"});

        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(StudentXML.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(student, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            StudentXML result = (StudentXML) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
