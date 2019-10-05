package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee3;

public class ManyToOne {
   public static void main( String[ ] args ) {
   
   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
   EntityManager entitymanager = emfactory.createEntityManager( );
   entitymanager.getTransaction( ).begin( );

   //Create Department Entity
   Department department = new Department();
   department.setName("Development");
   
   //Store Department
   entitymanager.persist(department);

   //Create Employee1 Entity
   Employee3 employee1 = new Employee3();
   employee1.setEname("Satish");
   employee1.setSalary(45000.0);
   employee1.setDeg("Technical Writer");
   employee1.setDepartment(department);

   //Create Employee2 Entity
   Employee3 employee2 = new Employee3();
   employee2.setEname("Krishna");
   employee2.setSalary(45000.0);
   employee2.setDeg("Technical Writer");
   employee2.setDepartment(department);

   //Create Employee3 Entity
   Employee3 employee3 = new Employee3();
   employee3.setEname("Masthanvali");
   employee3.setSalary(50000.0);
   employee3.setDeg("Technical Writer");
   employee3.setDepartment(department);

   //Store Employees
   entitymanager.persist(employee1);
   entitymanager.persist(employee2);
   entitymanager.persist(employee3);

   entitymanager.getTransaction().commit();
   entitymanager.close();
   emfactory.close();
   }
}