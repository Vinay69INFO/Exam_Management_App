package com.vinay.org.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String contact;
    private String address;
    private Double fees;
    private String admission_datecourse;
    private String course;
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private Integer role;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "student_subject",joinColumns =@JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="sub_id"))
    private Set<Subject> subjectList=new HashSet<Subject>();
    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getAdmission_datecourse() {
        return admission_datecourse;
    }

    public void setAdmission_datecourse(String admission_datecourse) {
        this.admission_datecourse = admission_datecourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Set<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
    
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", fees=" + fees + ", admission_datecourse=" + admission_datecourse + ", course=" + course + ", email=" + email + ", username=" + username + ", password=" + password + ", password=" + subjectList +'}';
    }
    
    
    
}
