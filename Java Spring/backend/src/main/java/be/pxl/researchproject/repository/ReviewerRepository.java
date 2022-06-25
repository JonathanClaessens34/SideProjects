package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
    Optional<Reviewer> findReviewerById(Long id);
}
