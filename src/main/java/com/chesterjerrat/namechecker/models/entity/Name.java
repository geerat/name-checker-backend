package com.chesterjerrat.namechecker.models.entity;

import com.chesterjerrat.namechecker.models.dto.AddName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "names")
public class Name {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "creation_time")
    private String creationTime;

    public Name() {

    }

    public Name(String name, String otherNames, String creationTime) {
        this.name = name;
        this.otherNames = otherNames;
        this.creationTime = creationTime;
    }

    public Name(AddName addName) {
        this.name = addName.getName().toLowerCase().trim();
        this.otherNames = addName.getOtherNames().toLowerCase().trim();
        this.creationTime = String.valueOf((System.currentTimeMillis()/1000));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
