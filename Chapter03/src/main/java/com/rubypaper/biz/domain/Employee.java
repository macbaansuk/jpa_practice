package com.rubypaper.biz.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.ToString;

@Data
@Entity// 일반자바객체와 구분하기위한 어노테이션, 생략불가, 엔티티 이름과 동일한 테이블 매핑 -> 이름 다르면 @Table
@Table(name = "S_EMP")
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
//	}
}