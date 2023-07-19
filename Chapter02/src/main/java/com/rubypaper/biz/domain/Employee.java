package com.rubypaper.biz.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity// 일반자바객체와 구분하기위한 어노테이션, 생략불가, 엔티티 이름과 동일한 테이블 매핑 -> 이름 다르면 @Table
@Table(name = "S_EMP",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME","MAILID"}) })// 엔티티와 매핑할 테이블 지정 , 이름이 다른 경우: name 속성으로 매핑
public class Employee {
	@Id //PK key
	@Column(length = 7, nullable = false)
	private Long id;
	
	@Column(length = 25, nullable = false)
	private String name;
	
	@Column(length = 8, nullable = true)
	private String mailId;
	
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(length = 25)
	private String title;
	
	
	@Column(name="DEPT_NAME", length = 30)
	private String deptName;
	
	@Column(precision = 11, scale = 2)
	private Double salary;
	
	@Column(name="COMISSION_PCT", precision = 4, scale = 2,
			columnDefinition = "double CHECK (comission_pct IN(10, 12.5, 15, 17.5, 20))")
	private Double comissionPct;
	
	@Transient
	private String searchCondition;
	
	@Transient
	private String searchKeyword;
	
	
	
}