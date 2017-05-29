package com.examples.com.employee;

import com.examples.com.EntityNotFoundException;
import com.examples.com.annotation.TimeTracer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<Long, Employee> employees = new HashMap<Long, Employee>();

    @TimeTracer
    public Employee insert(final Employee emp) {
        final Long id = new Random().nextLong();
        emp.setId(id);
        employees.put(id, emp);
        return emp;
    }

    public void update(final Employee emp) throws EntityNotFoundException {
        if (employees.get(emp.getId()) == null) {
            throw new EntityNotFoundException("Requested object is not present in the map!");
        }
    }

    public void delete(final Employee emp) {
    }
}



