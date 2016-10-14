package edu.cpp.cs356.assign1.student;

import org.apache.commons.lang3.StringUtils;

/**
 * This is a simple student class which requires a student ID.
 *
 * @author Wai Phyo
 */
public class Student {
    private String id;

    public Student(final String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("Student ID cannot be blank.");
        }
        this.id = id;
    }
}
