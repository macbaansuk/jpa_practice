package com.rubypaper.biz.client;

import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;


public class EmployeeServiceClient {
	
	public static void main(String[] args) {
		
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = //클라이언트 마다 생성
				Persistence.createEntityManagerFactory("Chapter03");
		
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		//엔티티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			//직원 엔티티 생성 및 초기화
			Employee employee = new Employee();
			employee.setName("둘리");
			
			//트랜잭션 시작
			tx.begin();
			
			//직원 등록
			em.persist(employee);  
			//1. 트랜잭션 시작 2. 회원 등록 3.트랜잭션 종료 -> 등록 작업이 트랜잭션 안에서 실행
			
			//트랜잭션 종료(COMMIT)
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//트랜잭션 종료(ROLLBACK)
			tx.rollback();
		} finally {
			//엔티티 매니저 및 엔티티 매니저 팩토리 종료
			em.close();
			emf.close();
		}
	}
}