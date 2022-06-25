package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReviewerTest {
    private Reviewer reviewer;

    private final String LASTNAME = "Tyreese Gibson", FIRSTNAME = "Tyreese", REVIEWCOMMENTARY = "Qualified", EMAIL = "tyreese@gmail.com";

    @BeforeEach
    public void init() {
        reviewer = new Reviewer();
        reviewer.setReviewCommentary(REVIEWCOMMENTARY);
        reviewer.setLastName(LASTNAME);
        reviewer.setFirstName(FIRSTNAME);
        reviewer.setMail(EMAIL);
    }

    @Test
    public void testSetters() {
        assertEquals(reviewer.getReviewCommentary(), REVIEWCOMMENTARY);
        assertEquals(reviewer.getLastName(), LASTNAME);
        assertEquals(reviewer.getFirstName(), FIRSTNAME);
        assertEquals(reviewer.getMail(), EMAIL);
    }

    @Test
    public void testEqualsSameCompany() {
        Reviewer contactPerson2 = reviewer;
        assertTrue(reviewer.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(reviewer.equals(null));
        assertFalse(reviewer.equals(a));
    }

    @Test
    public void testEquals() {
        Reviewer reviewer2 = new Reviewer();
        reviewer2.setReviewCommentary(REVIEWCOMMENTARY);
        reviewer2.setLastName(LASTNAME);
        reviewer2.setFirstName(FIRSTNAME);
        reviewer2.setMail(EMAIL);
        assertTrue(reviewer.equals(reviewer2));
        reviewer2.setFirstName("Steve");
        assertFalse(reviewer.equals(reviewer2));
    }
}
