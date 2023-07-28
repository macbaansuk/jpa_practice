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
			// 직원 엔티티 등록
			Employee employee = new Employee();
			employee.setName("둘리");
			
			//직원 이름 변경
			tx.begin();
			//직원 등록  --> 관리 상태로 전환
			em.persist(employee);
			//트랜잭션 종료(COMMIT)
			tx.commit(); 
			
			//모든 엔티티를 분리 상태로 전환시킨다.
			em.clear();
			
			//직원 엔티티 이름 수정
			tx.begin();
			employee.setName("뚤리");
			Employee mergedEmp = em.merge(employee); //mergedEmp만 관리상태
			tx.commit(); 
			
			//광리 상태 여부 확인
			System.out.println("employee 관리 : " + em.contains(employee));
			System.out.println("mergedEmp 관리 : " +em.contains(mergedEmp));
			
			
			
			
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