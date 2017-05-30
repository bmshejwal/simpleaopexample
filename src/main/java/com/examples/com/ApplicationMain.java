package com.examples.com;


import com.examples.com.annotation.TimeTracer;
import com.examples.com.employee.Employee;
import com.examples.com.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationMain {

    @Autowired
    private EmployeeService employeeService;

    @TimeTracer
    public void runForMe() throws EntityNotFoundException {
        System.out.println("Inside the method");
        final Employee emp = new Employee("a", new Date());
        employeeService.insert(emp);
        employeeService.delete(emp);

        employeeService.update(new Employee("b", new Date()));
    }

    public int multiplyByThree(final int i) {
        return i * 3;
    }

    /*public void generalMethod() {
        final String methodName = "generalMethod";
        System.out.println("Inside method: " + getClass() + " " + methodName);
        final TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // application business logic
        } catch (final RuntimeException exception) {
            System.out.println("Error: " + exception.getStackTrace());
            tx.setRollbackOnly();
            throw exception;
        } finally {
            transactionManager.commit(tx);
            System.out.println("Exiting method: " + getClass() + " " + methodName);
        }
    }*/

}


/*
Step1:
// Before executing any insert method print message "Entity being inserted for ...", print complete function name

// after executing any delete print "Entity being deleted ...", print entity

// if Entity is not found in map then throw EntityNotFoundException.
Write an aspect which handles this exception
and prints some good error message!

Step2 :
wild-card: the execution of any method with a name beginning with "set"
Try to implement insert aspect only for student and not for Employee
Delete should work for any

Step3:
// accept input as integer.
If int is negative don't proceed with execution of method and return 0;

Simply throw application exception in aspect


Step 4: combining pointcuts:
AND OR in pointcuts
*/

