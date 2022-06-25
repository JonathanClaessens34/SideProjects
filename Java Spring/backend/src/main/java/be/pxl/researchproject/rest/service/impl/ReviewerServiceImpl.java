package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.ReviewerDTO;
import be.pxl.researchproject.api.request.ReviewerRequest;
import be.pxl.researchproject.model.Reviewer;
import be.pxl.researchproject.repository.ReviewerRepository;
import be.pxl.researchproject.rest.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewerServiceImpl implements ReviewerService {
    private final ReviewerRepository reviewerRepository;

    @Autowired
    public ReviewerServiceImpl(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public List<ReviewerDTO> findAllReviewers() {
        return reviewerRepository.findAll()
                .stream().map(ReviewerDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewerDTO findReviewersById(Long id) {
        return reviewerRepository.findReviewerById(id)
                .map(ReviewerDTO::new)
                .orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public ReviewerDTO createReviewers(ReviewerRequest reviewerRequest) {
        Reviewer reviewer = new Reviewer();
        reviewer.setMail(reviewerRequest.getReviewerName());
        reviewer.setReviewCommentary(reviewerRequest.getReviewCommentary());
        Reviewer newReviewer = reviewerRepository.save(reviewer);
        return new ReviewerDTO(newReviewer);
    }

    @Override
    public ReviewerDTO updateReviewers(Long id, ReviewerRequest reviewerRequest) {
        return reviewerRepository.findReviewerById(id)
                .map(reviewer -> {
                    reviewer.setMail(reviewerRequest.getReviewerName());
                    reviewer.setReviewCommentary(reviewerRequest.getReviewCommentary());
                    return new ReviewerDTO(reviewerRepository.save(reviewer));
                }).orElseThrow(() -> new Error(id + " unable to update stagebegeleider"));
    }

    @Override
    public boolean deleteReviewers(Long id) {
        return reviewerRepository.findReviewerById(id)
                .map(reviewer -> {
                    reviewerRepository.delete(reviewer);
                    return true;
                }).orElseThrow(() -> new Error(id + " not found or couldn't delete contactpersoon"));
    }
}
