package com.ems.routes;

public final class ApiRoutes {

    private ApiRoutes() {
        // Prevent object creation
    }

    public static final String HOME = "/";
    public static final String HEALTH = "/api/health";

    // Employee API
    public static final String EMPLOYEES = "/api/employees";
    public static final String EMPLOYEE_BY_ID = "/api/employees/{id}";
}