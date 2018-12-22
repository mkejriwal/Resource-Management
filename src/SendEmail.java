

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
	//private static final long serialVersionUID = 1L;
	
	static String sendID="isd.project.resource@gmail.com";
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "587";
	static String pass="KAMP@1234";

	  protected void mailSend(String recID, String subject, String body)
	  {
//		String receiverEmailID;
//		String emailSubject;
//		String emailBody;
//	  // Receiver Email Address
//	  receiverEmailID=req.getParameter("toAddr"); 
//	  // Subject
//	  emailSubject=req.getParameter("subject");
//	  // Body
//	  emailBody=req.getParameter("body");
//	  //Sender's email-address
//	  senderEmailID=req.getParameter("user");
//	  //Sender's password
//	  pass=req.getParameter("pass");

	  Properties props = new Properties();
	  props.put("mail.smtp.user",sendID);
	  props.put("mail.smtp.host", emailSMTPserver);
	  props.put("mail.smtp.port", emailServerPort);
	  props.put("mail.smtp.auth", "true"); 
	  props.put("mail.smtp.starttls.enable", "true");
	  
	  
	  try
	  {  
	  Authenticator auth = new SMTPAuthenticator();
	  Session session = Session.getDefaultInstance(props, auth);
	  MimeMessage msg = new MimeMessage(session);
	  msg.setFrom(new InternetAddress(sendID, true));
	  msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recID));
	  msg.setText(body);
	  msg.setSubject(subject);
	  Transport.send(msg);
	  System.out.println("Message send Successfully:)"); 
	  }
	  catch (Exception mex){
	  mex.printStackTrace();}
	  
	  
	  }
	  
	  public class SMTPAuthenticator extends javax.mail.Authenticator
	  {
		  public PasswordAuthentication getPasswordAuthentication()
		  {
			  return new PasswordAuthentication(sendID, pass);
		  }
	  }

}
