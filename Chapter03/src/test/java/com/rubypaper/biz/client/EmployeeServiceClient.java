package com.rubypaper.biz.client;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;


public class EmployeeServiceClient {
	
	public static void main(String[] args) {
		
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = //클라이언트 마다 생성
				Persistence.createEntityManagerFactory("Chapter03");
		
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		//플러시 모드 설정
		em.setFlushMode(FlushModeType.COMMIT);
		
		//엔티티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//직원 검색
			Employee findEmp = em.find(Employee.class, 1L);
			
			
			//직원 이름 변경
			tx.begin();
			findEmp.setName("뚤리");
			//직원 등록  --> 관리 상태로 전환
			
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