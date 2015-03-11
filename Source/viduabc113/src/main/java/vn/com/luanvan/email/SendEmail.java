package vn.com.luanvan.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;


@Repository
public class SendEmail {
	@Autowired
	protected MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void GuiEmail(String taiKhoan, String tieuDe, String noiDung) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(taiKhoan);
		message.setSubject(tieuDe);
		message.setText(noiDung);
		message.setFrom("arcana.arcana.2015@gmail.com");
		mailSender.send(message);
	}
	
	public void GuiThongBaoTao(String taiKhoan, String tieuDe, String noiDung) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(tieuDe);
		message.setText(noiDung);
		message.setFrom("arcana.arcana.2015@gmail.com");
		message.setTo(taiKhoan);
		
		try {
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace(); //
		}	
	}
}
