package com.suren.learn;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

    private String id;
    private String fname;
    private String lname;
    private int age;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(String id, String fname, String lname, int age) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" + id + "," + fname + "," + lname + "," + age + "}";
    }

}