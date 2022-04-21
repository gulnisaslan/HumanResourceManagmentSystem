package kodlamaio.hrms.entities1.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "system_worker_confirms_of_job_adverts")
public class SystemWorkerConfirmsOfJobAdvert  extends ConfirmsOfSystemWorker{

	@NotNull
	@Column(name="job_advert_id")
	private int jobAdvertId;
}
