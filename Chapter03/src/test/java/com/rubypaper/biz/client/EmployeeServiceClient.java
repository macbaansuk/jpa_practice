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
			
			//직원 엔티티 생성 및 초기화
			Employee employee = new Employee();
			employee.setName("둘리");
			
			//트랜잭션 시작
			tx.begin();
			
			//직원 등록  --> 관리 상태로 전환
			em.persist(employee);  
			
			// 영속컨테이너는 삭제 엔티티에 대해서 DELETE -> 트랜잿견이 종료되는 시점에 DB에 전송
			//트랜잭션 종료(COMMIT)
			tx.commit(); 
			
			
			
			//직원 검색
			Employee findEmp1 = em.find(Employee.class, 1L);
			Employee findEmp2 = em.find(Employee.class, 1L);
			
			
			//객체의 동일성 비교
			if(findEmp1 == findEmp2) {
				System.out.println("검색된 두 객체는 동일한 객체다.");
			}
			
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