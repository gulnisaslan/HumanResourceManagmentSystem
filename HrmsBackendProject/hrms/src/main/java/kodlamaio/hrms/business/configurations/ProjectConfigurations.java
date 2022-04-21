package kodlamaio.hrms.business.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.cloudOperations.CloudService;
import kodlamaio.hrms.core.utilities.cloudOperations.CloudinaryManager;

@Configuration
public class ProjectConfigurations {
	
//    @Value("${cld.access-key}")
//    String apiAccessKey="913213616733342";
//    @Value("${cld.secret-key}")
//    String apiSecretKey="71vrgBh2vv_4R0g3N84BknZ84bI";
	
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name","hrms-project-kodlama-io",
				"api_key","913213616733342",
				"api_secret","71vrgBh2vv_4R0g3N84BknZ84bI"
				));
		
	}
	
	@Bean
	public CloudService cloudService() {
		return new CloudinaryManager(cloudinaryUser());
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
