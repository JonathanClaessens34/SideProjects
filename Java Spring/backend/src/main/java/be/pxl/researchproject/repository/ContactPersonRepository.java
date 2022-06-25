package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
    Optional<ContactPerson> findContactpersoonById(Long id);
}
