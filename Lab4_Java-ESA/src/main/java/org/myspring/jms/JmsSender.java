package org.myspring.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.myspring.model.BasicEntity;
import org.myspring.model.Change;
import org.myspring.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class JmsSender {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendObjectUpdate(BasicEntity object, String changeType) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> objectMap = objectMapper.convertValue(object, Map.class);
        for (String fieldName : objectMap.keySet()) {
            Change change = new Change(UUID.randomUUID().toString(),changeType, object.getId(), object.getTableName(), fieldName, objectMap.get(fieldName).toString());
            jmsTemplate.convertAndSend("changes",change);
        }
    }

    public void sendEmail(Email email){
        jmsTemplate.convertAndSend("emails",email);
    }
}
