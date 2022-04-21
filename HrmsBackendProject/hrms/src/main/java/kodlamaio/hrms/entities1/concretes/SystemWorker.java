package kodlamaio.hrms.entities1.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="system_workers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn()
public class SystemWorker extends User{

	@NotBlank(message = "İsim alanı boş olamaz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyadı alanı boş bırakılmaz")
	@Column(name="last_name")
	private String lastName;
	
	
	
}
