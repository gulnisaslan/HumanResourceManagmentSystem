package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfEmployerService;
import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfJobAdvertService;
import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.RandomStringGenerator;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities1.concretes.ActivationCode;
import kodlamaio.hrms.entities1.concretes.Employer;
import kodlamaio.hrms.entities1.concretes.JobAdvert;
import kodlamaio.hrms.entities1.concretes.JobSeeker;
import kodlamaio.hrms.entities1.concretes.SystemWorker;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfEmployer;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfJobAdvert;

@Service
public class AuthManager implements AuthService {

	@Autowired
	private JobSeekerService jobSeekerService;

	@Autowired
	private ActivationCodeService activationCodeService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EmployerService employerService;

	@Autowired
	private SystemWorkerConfirmsOfEmployerService systemWorkerConfirmsOfEmployerService;
	
	@Autowired
	private SystemWorkerConfirmsOfJobAdvertService systemWorkerConfirmsOfJobAdvertService;
	
	@Autowired
	private JobAdvertService jobAdvertService;
	
	@Autowired
	private SystemWorkerService systemWorkerService;

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) throws RemoteException {

		Result result = this.jobSeekerService.add(jobSeeker);

		if (!result.isSuccess()) {
			return result;
		}

		String activationCode = RandomStringGenerator.getRandomAlphaNumericString(); // burda doğrulama kodunu
																						// oluşturuyoruz

		while (this.checkIfActivationCodeExists(activationCode)) {
			activationCode = RandomStringGenerator.getRandomAlphaNumericString();
			// burda doğrulama kodu mevcut ise yeni bir doğrulama kodu oluşturuyoruz,
			// oluşturulan yeni doğrulama
			// kodu da mevcutsa yine bir doğrulama kodu oluşturuyoruz, bu işlemi oluşturulan
			// doğrulama kodu mevcut
			// bir doğrulama koduyla farklı olana kadar tekrarlıyoruz
		}

		ActivationCode newActivationCode = new ActivationCode();
		newActivationCode.setActivationCode(activationCode);
		newActivationCode.setUserId(jobSeeker.getId());

		this.activationCodeService.add(newActivationCode);

		this.emailService.sendSimpleMessage(jobSeeker.getEmailAddress(), "Doğrulama Kodu Bildirimi",
				"Kaydınızı tamamlamak için dorğulama kodunuz: " + activationCode);

		return new SuccessResult();
	}

	@Override
	public Result verifyJobSeeker(String userVCode, int jobSeekerId) {

		ActivationCode activationCode = this.activationCodeService.getByUserId(jobSeekerId).getData();

		JobSeeker jobSeeker = this.jobSeekerService.get(jobSeekerId).getData();

		if (activationCode.isActivated() == true) {
			return new ErrorResult("Bu hesap zaten aktifleştirilmiş, aktivasyon kodu zaten girilmiş");
		}

		if (!activationCode.getActivationCode().equals(userVCode)) {
			return new ErrorResult("Girdiğiniz aktivasyon kodu doğru değil");
		}

//		if (LocalDateTime.now().isAfter(activationCode.getExpirationDateTime())) {
//			return new ErrorResult("Girdiğiniz aktivasyon kodunun tarihi geçmiş");
//		}

		else {

			activationCode.setUserId(jobSeekerId);
			activationCode.setActivated(true);
			activationCode.setActivateDate(LocalDateTime.now());
			this.activationCodeService.add(activationCode);
			this.emailService.sendSimpleMessage(jobSeeker.getEmailAddress(), "İş Arayan Email Doğrulaması Bildirimi",
					"Girdiğiniz aktivasyon kodu doğru, hesabınız başarıyla aktifleştirildi.");
			return new SuccessResult();

		}

	}

	@Override
	public Result registerEmployer(Employer employer) throws RemoteException {

		Result result = this.employerService.add(employer);

		if (!result.isSuccess()) {
			return result;
		}

		String activationCode = RandomStringGenerator.getRandomAlphaNumericString(); // burda doğrulama kodunu
																						// oluşturuyoruz

		while (this.checkIfActivationCodeExists(activationCode)) {
			activationCode = RandomStringGenerator.getRandomAlphaNumericString();
			// burda doğrulama kodu mevcut ise yeni bir doğrulama kodu oluşturuyoruz,
			// oluşturulan yeni doğrulama
			// kodu da mevcutsa yine bir doğrulama kodu oluşturuyoruz, bu işlemi oluşturulan
			// doğrulama kodu mevcut
			// bir doğrulama koduyla farklı olana kadar tekrarlıyoruz
		}

		ActivationCode newActivationCode = new ActivationCode();
		newActivationCode.setActivationCode(activationCode);
		newActivationCode.setUserId(employer.getId());

		this.activationCodeService.add(newActivationCode);

		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Doğrulama Kodu Bildirimi",
				"Kaydınızı tamamlamak için dorğulama kodunuz: " + activationCode);

		return new SuccessResult();
	}

	@Override
	public Result verifyEmployer(String userACode, int employerId) {

		ActivationCode activationCode = this.activationCodeService.getByUserId(employerId).getData();

		Employer employer = this.employerService.get(employerId).getData();

		if (!activationCode.getActivationCode().equals(userACode)) {
			return new ErrorResult("Girdiğiniz aktivasyon kodu doğru değil");
		}

//		if (LocalDateTime.now().isAfter(activationCode.getExpirationDateTime())) {
//			return new ErrorResult("Girdiğiniz aktivasyon kodunun tarihi geçmiş");
//		}

		if (activationCode.isActivated() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmiş, hesap zaten aktifleştirilmiş");
		}

		else {

			activationCode.setUserId(employerId);
			activationCode.setActivated(true);
			activationCode.setActivateDate(LocalDateTime.now());
			this.activationCodeService.add(activationCode);
			this.emailService.sendSimpleMessage(employer.getEmailAddress(), "İş Veren Email Doğrulaması Bildirimi",
					"Girdiğiniz aktivasyon kodu doğru, hesabınız başarıyla aktifleştirildi.");
			return new SuccessResult();

		}

	}

	@Override
	public Result login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result systemPersonnelConfirmOfEmployer(int systemPersonnelId, int employerId) {
		ActivationCode activationCode = this.activationCodeService.getByUserId(employerId).getData();
		if (!activationCode.isActivated()) {
			return new ErrorResult("işverenin mail doğrulaması henüzgerçekleşmedi.");
		}
		Employer employer = this.employerService.get(employerId).getData();

		SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer = this.systemWorkerConfirmsOfEmployerService
				.findByEmployerId(employerId).getData();
		systemWorkerConfirmsOfEmployer.setSystemWorkerId(systemPersonnelId);
		systemWorkerConfirmsOfEmployer.setDidConfirm(true);
		systemWorkerConfirmsOfEmployer.setConfirmDate(LocalDateTime.now());
		this.systemWorkerConfirmsOfEmployerService.add(systemWorkerConfirmsOfEmployer);

		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "System Worker Confirmation of Employer Notice",
				"iş veren Hesabınız sistem çalışanı tarafından aktifleştirildi. Giriş yapabilirsiniz.");
		return new SuccessResult(
				"İşverennin sistem personeli tarafından doğrulaması tamamlandı, hesabı" + " tamamen aktifleştirildi.");
	}


	@Override
	public Result systemPersonnelConfirmOfJobAdvert(int systemWorkerId, int jobAdvertId) {
		SystemWorkerConfirmsOfJobAdvert confirmsOfJobAdvert =this.systemWorkerConfirmsOfJobAdvertService.findByJobAdvertId(jobAdvertId).getData();
		JobAdvert jobAdvert = this.jobAdvertService.get(jobAdvertId).getData();
	    
	    Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
	    
	    SystemWorkerConfirmsOfEmployer workerConfirmsOfEmployer=
	    		this.systemWorkerConfirmsOfEmployerService.findByEmployerId(employer.getId()).getData();
	    
	    SystemWorker systemWorkerForJobadvertConfirm=
	    		this.systemWorkerService.get(systemWorkerId).getData();
	    
	    if (!workerConfirmsOfEmployer.isDidConfirm()) {
			this.emailService.sendSimpleMessage(systemWorkerForJobadvertConfirm.getEmailAddress(), "İş ilanı dogrulama hatası", 
					"İş verenin iş ilanını henüz onaylanamaz.Önce iş vereni sistem çalışanı olarak onaylamanız gerekiyor.");
			return new ErrorResult("İş verenin doğrulamasını gerçekleştirmeden,iş ilanını onaylayamaz.");
	    }
	    confirmsOfJobAdvert.setSystemWorkerId(systemWorkerId);
	    confirmsOfJobAdvert.setDidConfirm(true);
	    confirmsOfJobAdvert.setConfirmDate(LocalDateTime.now());

	    jobAdvert.setPublishedDateTime(LocalDateTime.now());
	    this.systemWorkerConfirmsOfJobAdvertService.add(confirmsOfJobAdvert);
	    
	    this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Publishing Notice",
	    		"İş ilanınız sistem çalışanı tarafından onaylanarak yayın  alınmıştır.");
	    
	    this.emailService.sendSimpleMessage(systemWorkerForJobadvertConfirm.getEmailAddress(), "Job Advert Publishing Notice", 
	    		"İş ilanını başarıyla onayladınız ve onayladığınız iş ilanı yayına geçti!");
	    
		return new SuccessResult("İş ilanı sistem çalışanı tarafından onaylandı.");
	
	
	}

	private boolean checkIfActivationCodeExists(String activationCode) {
		return this.activationCodeService.getAll().getData().stream()
				.filter(aC -> aC.getActivationCode().equals(activationCode)).findFirst().isPresent(); // burda doğrulama
																										// kodunun
																										// mevcut olup
																										// olmadığını
																										// kontrol
																										// ediyoruz
	}

}
