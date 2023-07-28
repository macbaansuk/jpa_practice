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
			// 직원 엔티티 등록
			Employee employee = new Employee();
			employee.setName("둘리");
			
			//직원 이름 변경
			tx.begin();
			//직원 등록  --> 관리 상태로 전환
			em.persist(employee);
			//트랜잭션 종료(COMMIT)
			tx.commit(); 
			
			for(int i = 0; i < 30; i++) {
				Thread.sleep(1000);
				System.out.println("다른 사용자가 데이터 수정중 ... " + i);
			}
			
			//엔티티 REFRESH
			em.refresh(employee);
			System.out.println("갱신된 직우너 정보 : " + employee.toString());
			
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