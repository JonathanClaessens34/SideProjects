package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.InternshipDescriptionDTO;
import be.pxl.researchproject.api.dto.ReviewerDTO;
import be.pxl.researchproject.model.InternshipDescription;
import be.pxl.researchproject.model.Reviewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewerDTOTest {
    private final String firstName = "Tyrone", lastName = "Michels", mail = "Tyrone@gmail.com", reviewCommentary = "= Seems good!";
    private ReviewerDTO reviewerDTO;

    @BeforeEach
    public void init() {
        Reviewer reviewer = new Reviewer();
        reviewer.setFirstName(firstName);
        reviewer.setLastName(lastName);
        reviewer.setMail(mail);
        reviewer.setReviewCommentary(reviewCommentary);
        this.reviewerDTO = new ReviewerDTO(reviewer);
    }

    @Test
    public void testGetters() {
        assertEquals(reviewerDTO.getReviewerName(), mail);
        assertEquals(reviewerDTO.getReviewCommentary(), reviewCommentary);
    }
}
