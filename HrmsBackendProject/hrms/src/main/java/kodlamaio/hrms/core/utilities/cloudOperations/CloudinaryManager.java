package kodlamaio.hrms.core.utilities.cloudOperations;

import java.io.IOException;
import java.util.Map;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryManager implements CloudService {

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map cloudinaryUploader=cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader,"");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<>();
	}

}
