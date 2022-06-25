package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.InternshipDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternshipDescriptionRepository extends JpaRepository<InternshipDescription, Long> {
    Optional<InternshipDescription> findStageomschrijvingById(Long id);
}
