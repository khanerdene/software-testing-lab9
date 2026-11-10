package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void letterGradeReturnsExpectedLetter() {
        assertEquals("A", calc.letterGrade(100));
    }

    @Test
    void letterGradeThrowsWhenScoreIsOutsideRange() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1)),
            () -> assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(100.01))
        );
    }

    @Test
    void gpaThrowsForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test 
    void gpaThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[0]));
    }

    @Test
    void gpaReturnsCorrectlyForOneValue() {
        double[] scores = {95};
        assertEquals(4.0, calc.gpa(scores), 0.0001);
    }

    @Test
    void gpaReturnsAverageOfLetterGradePoints() {
        double[] scores = {95, 85, 75, 65, 50};
        assertEquals(2.0, calc.gpa(scores), 0.0001);
    }

    @Test 
    void scholarshipThrowsWhenGpaIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-2, 15, false));
    }

    @Test
    void scholarshipThrowsWhenGpaIsOver() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(5, 15, false));
    }

    @Test
    void scholarshipThrowsWhenCreditsIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -3, false));
    }

    @Test
    void noScholarshipWhenHasViolation() {
        assertEquals(0, calc.scholarship(3.9, 15, true));
    }

    @Test
    void fullScholarshipWhenHighGpaAndHighCredits() {
        assertEquals(100, calc.scholarship(3.9, 15, false));
    }

    @Test
    void partialScholarshipWhenMediumGpaAndMediumCredits() {
        assertEquals(70, calc.scholarship(3.6, 13, false));
    }

    //new
    @Test
    void partialScholarshipWhenHighGpaAndMediumCredits() {
        assertEquals(70, calc.scholarship(3.8, 13, false));
    }

    @Test
    void halfScholarshipWhenLowGpa() {
        assertEquals(50, calc.scholarship(3.1, 13, false));
    }

    //new
    @Test
    void halfScholarshipWhenMediumGpaLowCredits() {
        assertEquals(50, calc.scholarship(3.6, 10, false));
    }

    @Test
    void noScholarshipWhenRequirementsUnmet() {
        assertEquals(0, calc.scholarship(2.8, 10, false));
    }
}
