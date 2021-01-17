package org.myspring.jms;

import org.myspring.emailSender.EmailSender;
import org.myspring.model.Change;
import org.myspring.model.Email;
import org.myspring.repo.ChangesRepository;
import org.myspring.repo.EmailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {
    private final EmailSender emailSender;
    private final ChangesRepository changesRepository;
    private final EmailsRepository emailsRepository;

    @Autowired
    public JmsReceiver(EmailSender emailSender, ChangesRepository changesRepository, EmailsRepository emailsRepository) {
        this.emailSender = emailSender;
        this.changesRepository = changesRepository;
        this.emailsRepository = emailsRepository;
    }

    @JmsListener(destination = "changes", containerFactory = "myFactory")
    public void receiveChange(Change change){

        changesRepository.save(change);
    }

    @JmsListener(destination = "emails", containerFactory = "myFactory")
    public void receiveEmail(Email email){
        email.setEmail(emailSender.getSendTo());
        emailsRepository.save(email);
        emailSender.send(email.getCondition(),email.toString());
    }
}
