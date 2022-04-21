package kodlamaio.hrms.entities1.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="activation_codes")
@EqualsAndHashCode(callSuper = false)

public class ActivationCode {
     
	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name= "is_activated")
	private boolean isActivated=false;
	
	@Column(name="activate_date")
	private LocalDateTime activateDate;
	
	
	
}
 