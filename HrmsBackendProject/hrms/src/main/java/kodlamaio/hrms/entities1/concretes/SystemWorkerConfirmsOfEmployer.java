package kodlamaio.hrms.entities1.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="system_worker_confirms_of_employers")
public class SystemWorkerConfirmsOfEmployer extends ConfirmsOfSystemWorker {
	@Column(name = "employer_id")
	private int employerId;
}
