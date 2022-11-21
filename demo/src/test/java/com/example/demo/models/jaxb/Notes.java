package com.example.demo.models.jaxb;

import com.example.demo.models.NoteData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "notes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notes {

    @XmlElement(name = "note")
    private List<NoteData> notes;

    public List<NoteData> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteData> notes) {
        this.notes = notes;
    }
}
