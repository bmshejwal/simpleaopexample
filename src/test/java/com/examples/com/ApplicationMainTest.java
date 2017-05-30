package com.examples.com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:test-application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationMainTest {

    @Autowired
    ApplicationMain t1;


    @Test
    public void testName1() throws Exception, EntityNotFoundException {
        Assert.assertNotNull(t1);
        t1.runForMe();
        System.out.println("Multiplication is: " + t1.multiplyByThree(-3));
    }
}
