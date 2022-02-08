package org.launchcode.techjobs.oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static java.lang.Character.isWhitespace;
import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;


    @Before
    public void createJobObject() {
        test_job1 = new Job("Web-Dev Master", new Employer("Employer"), new Location("St. Louis"), new PositionType("Web Developer"),new CoreCompetency("Java") );
        test_job2 = new Job("Web-Dev Master", new Employer("Employer"), new Location("St. Louis"), new PositionType("Web Developer"),new CoreCompetency("Java") );
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobID() {
        assertEquals(test_job2.getId() - test_job1.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        assertTrue(test_job3.getName() != "");
        assertTrue(test_job3.getId() != 0);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(test_job3.getEmployer().getValue(), ("ACME"));
        assertEquals(test_job3.getLocation().getValue(), ("Desert"));
        assertEquals(test_job3.getPositionType().getValue(), ("Quality control"));
        assertEquals(test_job3.getCoreCompetency().getValue(), ("Persistence"));

    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job1.equals(test_job2));
    }

    @Test
    public void returnsString() {
        int stringLength = test_job1.toString().length();
        assertTrue(isWhitespace(test_job1.toString().charAt(0)));
        assertTrue(isWhitespace(test_job1.toString().charAt(stringLength-1)));
        assertTrue(test_job1.toString().contains('\n' + "ID: " + test_job1.getId()));
        assertTrue(test_job1.toString().contains('\n' + "Name: " + test_job1.getName()));
        assertTrue(test_job1.toString().contains('\n' + "Employer: " + test_job1.getEmployer().getValue()));
        assertTrue(test_job1.toString().contains('\n' + "Location: " + test_job1.getLocation().getValue()));
        assertTrue(test_job1.toString().contains('\n' + "Position Type: " + test_job1.getPositionType().getValue()));
        assertTrue(test_job1.toString().contains('\n' + "Core Competency: " + test_job1.getCoreCompetency().getValue()));
        assertTrue(test_job4.toString().contains(": Data not available"));


    }

}
