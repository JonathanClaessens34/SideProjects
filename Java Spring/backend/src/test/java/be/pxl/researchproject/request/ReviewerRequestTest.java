package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.ReviewerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewerRequestTest {
    private String reviewerName = "Steve", reviewCommentary = "Seems good!";
    private ReviewerRequest reviewerRequest;

    @BeforeEach
    public void init() {
        reviewerRequest = new ReviewerRequest(reviewerName, reviewCommentary);
        reviewerRequest.setReviewerName(reviewerName);
        reviewerRequest.setReviewCommentary(reviewCommentary);
    }

    @Test
    public void testGetters() {
        assertEquals(reviewerRequest.getReviewCommentary(), reviewCommentary);
        assertEquals(reviewerRequest.getReviewerName(), reviewerName);
    }
}
