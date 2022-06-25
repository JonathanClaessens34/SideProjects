package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.MailDTO;
import be.pxl.researchproject.api.request.MailRequest;

import java.util.List;

public interface MailService {
    List<MailDTO> findAllMails();
    MailDTO findMailById(Long id);
    MailDTO createMail(MailRequest mailRequest);
    MailDTO updateMail(Long id, MailRequest mailRequest);
    boolean deleteMail(Long id);
}
