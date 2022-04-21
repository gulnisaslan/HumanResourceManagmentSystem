package kodlamaio.hrms.entities1.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="confirms_of_system_workers")
@EqualsAndHashCode(callSuper =false)
@Inheritance(strategy = InheritanceType.JOINED)
public class ConfirmsOfSystemWorker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="system_worker_id")
	private int systemWorkerId;
	
	@Column(name="did_confirm")
	private boolean didConfirm;
	
	@Column(name="confirm_date")
	private LocalDateTime confirmDate;

	

}
