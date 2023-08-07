package com.rubypaper.biz.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 25, nullable = false)
	private String name;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER) //양방향 매핑을 위해 두 객체에 모두 @OneToOne 설정
	@JoinColumn(name = "EMP_CARD_ID")  //외래키 칼럼 이름
	private EmployeeCard card;

	public void setEmployeeCard(EmployeeCard card){ ///양방향 참조 메서드
		this.card = card;
		card.setEmployee(this);
	}
		
}
