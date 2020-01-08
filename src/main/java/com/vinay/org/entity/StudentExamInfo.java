/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vinay
 */
@Entity
public class StudentExamInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String examstatus;
    private String date;
    
    @OneToOne
    private Student st;
    @OneToOne
    private Subject sub;
    
    
    public StudentExamInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamstatus() {
        return examstatus;
    }

    public void setExamstatus(String examstatus) {
        this.examstatus = examstatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "StudentExamInfo{" + "id=" + id + ", examstatus=" + examstatus + ", date=" + date + ", st=" + st + ", sub=" + sub + '}';
    }

    
    
    
    
}
