/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sub_id;
    //@Column( name = "sub_name", unique = true, nullable = false)
    private String sub_name;
    private Integer max_marks;
    private Integer Passing_marks;
    private Integer total_questions;
    private Integer duration;
    private Integer fees;
    private Integer offer;

    public Subject() {
    }

    public Integer getSub_id() {
        return sub_id;
    }

    public void setSub_id(Integer sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public Integer getMax_marks() {
        return max_marks;
    }

    public void setMax_marks(Integer max_marks) {
        this.max_marks = max_marks;
    }

    public Integer getPassing_marks() {
        return Passing_marks;
    }

    public void setPassing_marks(Integer Passing_marks) {
        this.Passing_marks = Passing_marks;
    }

    public Integer getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(Integer total_questions) {
        this.total_questions = total_questions;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Subject{" + "sub_id=" + sub_id + ", name=" + sub_name + ", max_marks=" + max_marks + ", Passing_marks=" + Passing_marks + ", total_questions=" + total_questions + ", duration=" + duration + ", fees=" + fees + ", offer=" + offer + '}';
    }

    
    
}
