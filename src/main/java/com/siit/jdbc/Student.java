package com.siit.jdbc;


public class Student {
    private int id;
    private String name;
    private int course_id;

    public Student(int id, String name, int course_id) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }
}
