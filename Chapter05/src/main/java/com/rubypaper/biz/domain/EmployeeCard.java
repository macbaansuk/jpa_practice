package com.rubypaper.biz.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "employee") //toString에서 employee제외
@Entity
@Table(name = "S_EMP_CARD")
public class EmployeeCard {

	
	@Id //@GeneratedValue -> employee객체의 식별자 값을 같이 사용하기위해 지움
	@Column(name = "CARD_ID")
	private Long CardId; //사원증 아이디
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate; //사원증 만료기간
	
	private String role;  //권한
	
	@MapsId //@JoinColumn으로 매핑한 외래키 칼럼을 기본키 칼럼으로 사용
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private Employee employee;
	
	
}
