package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.InternshipAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternshipAssignmentRepository extends JpaRepository<InternshipAssignment, Long> {
    Optional<InternshipAssignment> findStageopdrachtById(Long id);
}
