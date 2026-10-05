package com.example.monitoring.health;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        boolean employeeServiceAvailable = true;

        if (employeeServiceAvailable) {
            return Health.up()
                    .withDetail("employeeService", "Available")
                    .withDetail("message", "Employee service is working")
                    .build();
        }

        return Health.down()
                .withDetail("employeeService", "Unavailable")
                .withDetail("message", "Employee service is not working")
                .build();
    }
}