package kodlamaio.hrms.core.utilities.results;

public class Result {
	
	private String message;
	private boolean success;
	
        public Result(String message, boolean success) {
		this(success);
		this.message = message;
		this.success = success;
	}

	public Result(boolean success) {
			this.success = success;
	}
		public boolean isSuccess() {
			return success;
		}
		public String getMessage() {
			return message;
		}
}
