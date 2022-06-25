package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.Reviewer;

public class ReviewerDTO {
    private String reviewerName, reviewCommentary;

    public ReviewerDTO(Reviewer reviewer) {
        this.reviewerName = reviewer.getMail();
        this.reviewCommentary = reviewer.getReviewCommentary();
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewCommentary() {
        return reviewCommentary;
    }
}
