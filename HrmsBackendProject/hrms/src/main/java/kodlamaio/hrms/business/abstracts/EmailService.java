package kodlamaio.hrms.business.abstracts;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);
}
