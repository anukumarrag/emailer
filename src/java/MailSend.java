/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author anurag
 * 
 * 
 */
public class MailSend {
   
    
    
     public static String email2( GetProperty api,String email,String subject, String mymsg){
        String status="";
        try{ 
        Properties props = System.getProperties();
        props.put("mail.smtps.host",api.getSmtp());
        props.put("mail.smtps.auth","true");
        props.put("mail.smtp.port",api.getPort());
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(api.getFrom()));
        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email, false));
      
        msg.setSubject(subject);
        msg.setContent(mymsg, "text/html; charset=utf-8");
        
        msg.setSentDate(new Date());
        SMTPTransport t =(SMTPTransport)session.getTransport("smtps");
        t.connect(api.getSmtp(), api.getUser(), api.getPassword());
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse() + " to= "+email);
        status=t.getLastServerResponse()+" to "+email+" ";
        t.close();
        
        
        }
        catch(MessagingException e){
            
        }
        
        return status;
}
    
    
    
     
}
