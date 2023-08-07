package com.rubypaper.biz.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP_CARD")
public class EmployeeCard {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_ID")
	private Long CardId; //사원증 아이디
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate; //사원증 만료기간
	
	private String role;  //권한
	
	@OneToOne(optional = false, fetch = FetchType.LAZY) //optinial = 외부 - > 내부 조인
	@JoinColumn(name = "EMP_CARD_ID")
	private Employee employee;
}
