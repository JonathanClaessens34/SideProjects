package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    Optional<Mail> findMailById(Long id);
}
