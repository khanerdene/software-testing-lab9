package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ScholarshipCalculatorTest {
    
    @Test
    void letterGradeCalculatesCorrectly() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        String letterGrade = calc.letterGrade(100);

        assertEquals("A", letterGrade);
    }

    @Test 
    void letterGradeCalculatesCorrectlyOnBoundary() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        String letterGrade = calc.letterGrade(60);

        assertEquals("F", letterGrade);
    }

    @Test 
    void gpaCalculatesCorrectly() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        double[] scores = {100.0, 90.0, 85.0};

        double gpa = calc.gpa(scores);

        assertEquals((double) 11/3, gpa);
    }

    @Test 
    void scholarshipCalculatesCorrectly() {
        ScholarshipCalculator calc = new ScholarshipCalculator();

        double gpa = 3.5;
        int credits = 18;
        boolean violation = false;

        int scholarship = calc.scholarship(gpa, credits, violation);

        assertEquals(70, scholarship);
    }
}
