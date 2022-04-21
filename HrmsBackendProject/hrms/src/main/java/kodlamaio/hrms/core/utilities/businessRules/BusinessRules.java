package kodlamaio.hrms.core.utilities.businessRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	public static Result businessRules(Result... logics) {
		for (Result logic : logics) {
			if(!logic.isSuccess()) {
				 return logic;
				
			}
		}
		return new SuccessResult();
		
	}
}
