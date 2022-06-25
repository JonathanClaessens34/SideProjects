package be.pxl.researchproject.api.request;

public class ReviewerRequest {
    private String reviewerName, reviewCommentary;

    public ReviewerRequest(String reviewerName, String reviewCommentary) {
        this.reviewerName = reviewerName;
        this.reviewCommentary = reviewCommentary;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewCommentary() {
        return reviewCommentary;
    }

    public void setReviewCommentary(String reviewCommentary) {
        this.reviewCommentary = reviewCommentary;
    }
}
