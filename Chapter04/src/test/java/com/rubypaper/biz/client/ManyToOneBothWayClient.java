package com.rubypaper.biz.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Department;
import com.rubypaper.biz.domain.Employee;

public class ManyToOneBothWayClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("Chapter04");
		try {		
			dataInsert(emf);
			dataSelect(emf);
//			dataDelete(emf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
		}
	}
	
//	private static void dataDelete(EntityManagerFactory emf) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		// 부서 검색
//		Department departmemt = em.find(Department.class, 1L);
//
//		// 직원의 부서 정보 수정
//		List<Employee> employeeList = departmemt.getEmployeeList();		
//		for (Employee employee : employeeList) {
//			employee.standby();
//		}
//
//		// 부서 삭제
//		em.remove(departmemt);
//
//
//		em.getTransaction().commit();
//		em.close();
//	}

	private static void dataSelect(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		Department department = em.find(Department.class, 1L);
		
		System.out.println("검색된 부서 : " + department.getName());
		System.out.println("부서에 소속된 직원 명단");
		for (Employee employee : department.getEmployeeList()) {
			System.out.println(employee.getName() + "(" + 
				employee.getDept().getName() + ")");
		}
	}


	private static void dataInsert(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		// 부서 등록
		Department departmemt = new Department();
		departmemt.setName("개발부");
		em.persist(departmemt);
		
		// 직원 등록
		Employee employee1 = new Employee();
		employee1.setName("둘리");
		employee1.setDept(departmemt);
		em.persist(employee1);
		
		// 직원 등록
		Employee employee2 = new Employee();
		employee2.setName("도우너");
		employee2.setDept(departmemt);
		em.persist(employee2);
		
		
		// Department.employeeList에 Employee 등록
//		departmemt.getEmployeeList().add(employee1);
//		departmemt.getEmployeeList().add(employee2);
		
		System.out.println(departmemt.getName() + "의 직원 수 : " +
		departmemt.getEmployeeList().size());
		
		em.getTransaction().commit();
		em.close();
	}
}
