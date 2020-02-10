package com.chesterjerrat.namechecker.models.entity;

import com.chesterjerrat.namechecker.models.dto.AddOpinion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "opinions")
public class Opinion {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "experience")
    private String experience;

    @Column(name = "timestamp")
    private String timestamp;

    public Opinion() {

    }

    public Opinion(String name, AddOpinion addOpinion) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.comment = addOpinion.getComment();
        this.experience = addOpinion.getExperience();
        this.timestamp = String.valueOf((System.currentTimeMillis()/1000));
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
