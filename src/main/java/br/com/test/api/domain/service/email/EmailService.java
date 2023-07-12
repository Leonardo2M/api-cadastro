package br.com.test.api.domain.service.email;

import br.com.test.api.domain.model.EmailModel;
import br.com.test.api.domain.model.enums.StatusEmail;
import br.com.test.api.domain.repository.email.EmailRepository;
import br.com.test.api.dto.email.EmailDTO;
import br.com.test.api.dto.pessoa.PessoaAniversarioDTO;
import br.com.test.api.dto.email.MessagemParabens;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmailService {

    private EmailRepository repository;
    private final ModelMapper modelMapper;
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

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

    public void sendPasswordEmail(String emailUsuario) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.emailFrom);
            message.setTo(emailUsuario);
            message.setSubject("Cadastro realizado.");
            message.setText("Cadastro realizado com sucesso\n"
                    + "senha para primeiro acesso: " + gerarSenha());
            emailSender.send(message);

        } catch (MailException e){
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<List<PessoaAniversarioDTO>> enviarParabens(MessagemParabens messagemParabens) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.emailFrom);
            message.setTo(messagemParabens.getToEmail());
            message.setSubject(messagemParabens.getNome() + " te deseja parabéns!");
            message.setText(messagemParabens.getDescricao());
            emailSender.send(message);

            return ResponseEntity.ok().build();
        } catch (MailException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    private static String gerarSenha() {
        UUID uuid = UUID.randomUUID();
        String senha = uuid.toString().substring(0, 7);

        return senha;
    }


}
