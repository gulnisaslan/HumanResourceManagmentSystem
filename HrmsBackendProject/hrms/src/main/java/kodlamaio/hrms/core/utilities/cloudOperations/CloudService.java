package kodlamaio.hrms.core.utilities.cloudOperations;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {

	DataResult<?> save(MultipartFile file);
}
