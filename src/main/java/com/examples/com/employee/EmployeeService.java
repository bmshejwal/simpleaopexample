package com.examples.com.employee;

import com.examples.com.EntityNotFoundException;

public interface EmployeeService {
    Employee insert(Employee emp);
    void update(Employee emp) throws EntityNotFoundException;
    void delete(Employee emp);
}
