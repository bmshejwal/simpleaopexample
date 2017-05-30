package com.examples.com.employee;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<Long, Employee> employees = new HashMap<Long, Employee>();

    public Employee insert(final Employee emp) {
        final Long id = new Random().nextLong();
        emp.setId(id);
        employees.put(id, emp);
        return emp;
    }

    public void delete(final Employee emp) {
    }
}



