package com.examples.com.student;

import com.examples.com.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private Map<Long, Employee> students = new HashMap<Long, Employee>();

    public Student insert(final Student student) {
        return null;
    }

    public void update(final Student student) {

    }

    public void delete(final Student student) {

    }
}
