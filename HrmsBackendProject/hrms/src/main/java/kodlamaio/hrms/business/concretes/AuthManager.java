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

		String activationCode = RandomStringGenerator.getRandomAlphaNumericString(); // burda do??rulama kodunu
																						// olu??turuyoruz

		while (this.checkIfActivationCodeExists(activationCode)) {
			activationCode = RandomStringGenerator.getRandomAlphaNumericString();
			// burda do??rulama kodu mevcut ise yeni bir do??rulama kodu olu??turuyoruz,
			// olu??turulan yeni do??rulama
			// kodu da mevcutsa yine bir do??rulama kodu olu??turuyoruz, bu i??lemi olu??turulan
			// do??rulama kodu mevcut
			// bir do??rulama koduyla farkl?? olana kadar tekrarl??yoruz
		}

		ActivationCode newActivationCode = new ActivationCode();
		newActivationCode.setActivationCode(activationCode);
		newActivationCode.setUserId(jobSeeker.getId());

		this.activationCodeService.add(newActivationCode);

		this.emailService.sendSimpleMessage(jobSeeker.getEmailAddress(), "Do??rulama Kodu Bildirimi",
				"Kayd??n??z?? tamamlamak i??in dor??ulama kodunuz: " + activationCode);

		return new SuccessResult();
	}

	@Override
	public Result verifyJobSeeker(String userVCode, int jobSeekerId) {

		ActivationCode activationCode = this.activationCodeService.getByUserId(jobSeekerId).getData();

		JobSeeker jobSeeker = this.jobSeekerService.get(jobSeekerId).getData();

		if (activationCode.isActivated() == true) {
			return new ErrorResult("Bu hesap zaten aktifle??tirilmi??, aktivasyon kodu zaten girilmi??");
		}

		if (!activationCode.getActivationCode().equals(userVCode)) {
			return new ErrorResult("Girdi??iniz aktivasyon kodu do??ru de??il");
		}

//		if (LocalDateTime.now().isAfter(activationCode.getExpirationDateTime())) {
//			return new ErrorResult("Girdi??iniz aktivasyon kodunun tarihi ge??mi??");
//		}

		else {

			activationCode.setUserId(jobSeekerId);
			activationCode.setActivated(true);
			activationCode.setActivateDate(LocalDateTime.now());
			this.activationCodeService.add(activationCode);
			this.emailService.sendSimpleMessage(jobSeeker.getEmailAddress(), "???? Arayan Email Do??rulamas?? Bildirimi",
					"Girdi??iniz aktivasyon kodu do??ru, hesab??n??z ba??ar??yla aktifle??tirildi.");
			return new SuccessResult();

		}

	}

	@Override
	public Result registerEmployer(Employer employer) throws RemoteException {

		Result result = this.employerService.add(employer);

		if (!result.isSuccess()) {
			return result;
		}

		String activationCode = RandomStringGenerator.getRandomAlphaNumericString(); // burda do??rulama kodunu
																						// olu??turuyoruz

		while (this.checkIfActivationCodeExists(activationCode)) {
			activationCode = RandomStringGenerator.getRandomAlphaNumericString();
			// burda do??rulama kodu mevcut ise yeni bir do??rulama kodu olu??turuyoruz,
			// olu??turulan yeni do??rulama
			// kodu da mevcutsa yine bir do??rulama kodu olu??turuyoruz, bu i??lemi olu??turulan
			// do??rulama kodu mevcut
			// bir do??rulama koduyla farkl?? olana kadar tekrarl??yoruz
		}

		ActivationCode newActivationCode = new ActivationCode();
		newActivationCode.setActivationCode(activationCode);
		newActivationCode.setUserId(employer.getId());

		this.activationCodeService.add(newActivationCode);

		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Do??rulama Kodu Bildirimi",
				"Kayd??n??z?? tamamlamak i??in dor??ulama kodunuz: " + activationCode);

		return new SuccessResult();
	}

	@Override
	public Result verifyEmployer(String userACode, int employerId) {

		ActivationCode activationCode = this.activationCodeService.getByUserId(employerId).getData();

		Employer employer = this.employerService.get(employerId).getData();

		if (!activationCode.getActivationCode().equals(userACode)) {
			return new ErrorResult("Girdi??iniz aktivasyon kodu do??ru de??il");
		}

//		if (LocalDateTime.now().isAfter(activationCode.getExpirationDateTime())) {
//			return new ErrorResult("Girdi??iniz aktivasyon kodunun tarihi ge??mi??");
//		}

		if (activationCode.isActivated() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmi??, hesap zaten aktifle??tirilmi??");
		}

		else {

			activationCode.setUserId(employerId);
			activationCode.setActivated(true);
			activationCode.setActivateDate(LocalDateTime.now());
			this.activationCodeService.add(activationCode);
			this.emailService.sendSimpleMessage(employer.getEmailAddress(), "???? Veren Email Do??rulamas?? Bildirimi",
					"Girdi??iniz aktivasyon kodu do??ru, hesab??n??z ba??ar??yla aktifle??tirildi.");
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
			return new ErrorResult("i??verenin mail do??rulamas?? hen??zger??ekle??medi.");
		}
		Employer employer = this.employerService.get(employerId).getData();

		SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer = this.systemWorkerConfirmsOfEmployerService
				.findByEmployerId(employerId).getData();
		systemWorkerConfirmsOfEmployer.setSystemWorkerId(systemPersonnelId);
		systemWorkerConfirmsOfEmployer.setDidConfirm(true);
		systemWorkerConfirmsOfEmployer.setConfirmDate(LocalDateTime.now());
		this.systemWorkerConfirmsOfEmployerService.add(systemWorkerConfirmsOfEmployer);

		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "System Worker Confirmation of Employer Notice",
				"i?? veren Hesab??n??z sistem ??al????an?? taraf??ndan aktifle??tirildi. Giri?? yapabilirsiniz.");
		return new SuccessResult(
				"????verennin sistem personeli taraf??ndan do??rulamas?? tamamland??, hesab??" + " tamamen aktifle??tirildi.");
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
			this.emailService.sendSimpleMessage(systemWorkerForJobadvertConfirm.getEmailAddress(), "???? ilan?? dogrulama hatas??", 
					"???? verenin i?? ilan??n?? hen??z onaylanamaz.??nce i?? vereni sistem ??al????an?? olarak onaylaman??z gerekiyor.");
			return new ErrorResult("???? verenin do??rulamas??n?? ger??ekle??tirmeden,i?? ilan??n?? onaylayamaz.");
	    }
	    confirmsOfJobAdvert.setSystemWorkerId(systemWorkerId);
	    confirmsOfJobAdvert.setDidConfirm(true);
	    confirmsOfJobAdvert.setConfirmDate(LocalDateTime.now());

	    jobAdvert.setPublishedDateTime(LocalDateTime.now());
	    this.systemWorkerConfirmsOfJobAdvertService.add(confirmsOfJobAdvert);
	    
	    this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Publishing Notice",
	    		"???? ilan??n??z sistem ??al????an?? taraf??ndan onaylanarak yay??n  al??nm????t??r.");
	    
	    this.emailService.sendSimpleMessage(systemWorkerForJobadvertConfirm.getEmailAddress(), "Job Advert Publishing Notice", 
	    		"???? ilan??n?? ba??ar??yla onaylad??n??z ve onaylad??????n??z i?? ilan?? yay??na ge??ti!");
	    
		return new SuccessResult("???? ilan?? sistem ??al????an?? taraf??ndan onayland??.");
	
	
	}

	private boolean checkIfActivationCodeExists(String activationCode) {
		return this.activationCodeService.getAll().getData().stream()
				.filter(aC -> aC.getActivationCode().equals(activationCode)).findFirst().isPresent(); // burda do??rulama
																										// kodunun
																										// mevcut olup
																										// olmad??????n??
																										// kontrol
																										// ediyoruz
	}

}
