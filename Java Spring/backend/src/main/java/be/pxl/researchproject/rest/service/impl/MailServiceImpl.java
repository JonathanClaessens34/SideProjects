package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.api.dto.MailDTO;
import be.pxl.researchproject.api.request.MailRequest;
import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.model.Mail;
import be.pxl.researchproject.repository.MailRepository;
import be.pxl.researchproject.rest.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailServiceImpl implements MailService {

    private final MailRepository mailRepository;

    @Autowired
    public MailServiceImpl(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public List<MailDTO> findAllMails() {
        return mailRepository.findAll()
                .stream()
                .map(MailDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public MailDTO findMailById(Long id) {
        return mailRepository.findMailById(id)
                .map(MailDTO::new)
                .orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public MailDTO createMail(MailRequest mailRequest) {
        Mail mail = new Mail();
        mail.setUsername(mailRequest.getUsername());
        mail.setSubject(mailRequest.getSubject());
        mail.setRecipients(mailRequest.getRecipients());
        mail.setMessage(mailRequest.getMsg());
        Mail newMail = mailRepository.save(mail);
        return new MailDTO(newMail);
    }

    @Override
    public MailDTO updateMail(Long id, MailRequest mailRequest) {
        return mailRepository.findMailById(id)
                .map(mail -> {
                    mail.setUsername(mailRequest.getUsername());
                    mail.setSubject(mailRequest.getSubject());
                    mail.setRecipients(mailRequest.getRecipients());
                    mail.setMessage(mailRequest.getMsg());
                    return new MailDTO(mailRepository.save(mail));
                }).orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public boolean deleteMail(Long id) {
        return mailRepository.findMailById(id)
                .map(mail -> {
                    mailRepository.delete(mail);
                    return true;
                }).orElseThrow(() -> new Error(id + " not found"));
    }
}
