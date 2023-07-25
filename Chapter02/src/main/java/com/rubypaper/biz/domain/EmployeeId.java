package com.rubypaper.biz.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString 
public class EmployeeId implements Serializable {
	private static final long serialVersionUID = 1L;

	//복합키에 해당하는 변수들만 선언
	private Long id;
	private String mailId;
}
