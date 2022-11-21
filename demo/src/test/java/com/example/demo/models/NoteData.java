package com.example.demo.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoteData {
    @XmlElement(name = "content", required = true)
    public String record;

    public NoteData() {
    }

    public NoteData(String record) {
        this.record = record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRecord() {
        return this.record;
    }

}
