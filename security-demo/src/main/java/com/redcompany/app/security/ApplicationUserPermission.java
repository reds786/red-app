package com.redcompany.app.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }


    public String getPermission() {
        return permission;
    }

    private final String permission;

}

