package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "faculty")
public class FacultyXML {

    @XmlAttribute
    private String name;

    public FacultyXML() {
    }

    public FacultyXML(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty{"
                + "name='" + name + '\''
                + '}';
    }
}
