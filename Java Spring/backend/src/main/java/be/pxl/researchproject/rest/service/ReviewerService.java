package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.ReviewerDTO;
import be.pxl.researchproject.api.request.ReviewerRequest;

import java.util.List;

public interface ReviewerService {
    List<ReviewerDTO> findAllReviewers();
    ReviewerDTO findReviewersById(Long id);
    ReviewerDTO createReviewers(ReviewerRequest stagebegeleiderRequest);
    ReviewerDTO updateReviewers(Long id, ReviewerRequest stagebegeleiderRequest);
    boolean deleteReviewers(Long id);
}
