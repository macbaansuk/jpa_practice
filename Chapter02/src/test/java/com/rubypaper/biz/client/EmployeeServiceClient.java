package com.rubypaper.biz.client;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;

public class EmployeeServiceClient {
	
	public static void main(String[] args) {
		
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = //클라이언트 마다 생성
				Persistence.createEntityManagerFactory("Chapter02");
		
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		//엔티티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// 직원 엔티티 생성 및 초기화
			Employee employee  = new Employee(1L, "둘리", "gurum",new Date(), "과장", "총무부", 2500.00, 12.50, null, null);
			
			//회원 등록 요청
			tx.begin();
			em.persist(employee);
			tx.commit();
			
			//등록한 회원 검색
			Employee findEmployee = em.find(Employee.class, 1L); //find - 검색
			System.out.println("검색한 회원 정보");
			System.out.println(findEmployee.toString());
			
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