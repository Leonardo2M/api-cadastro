package br.com.test.api.domain.service.email;

import br.com.test.api.domain.model.EmailModel;
import br.com.test.api.domain.model.enums.StatusEmail;
import br.com.test.api.domain.repository.email.EmailRepository;
import br.com.test.api.dto.email.EmailDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private EmailRepository repository;
    private final ModelMapper modelMapper;
    private final JavaMailSender emailSender;

    public EmailService(EmailRepository repository, ModelMapper modelMapper, JavaMailSender emailSender) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.emailSender = emailSender;
    }

    public EmailModel convertToEntity(EmailDTO emailDto) {
        return modelMapper.map(emailDto, EmailModel.class);
    }

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            System.out.println(e.getMessage());
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return repository.save(emailModel);
        }
    }


}
