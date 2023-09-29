package com.spring.orm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ormdao.StudentDao;
import com.spring.ormentities.Student;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          boolean go=true;
		while (go) {
			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for display all student");
			System.out.println("Press 3 for get detail of single student");
			System.out.println("Press 4 for delete student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add new student
					
					System.out.println("Enter user id :");
					int uId=Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name :");
					String uName=br.readLine();
					
					System.out.println("Enter user city :");
					String uCity=br.readLine(); 
					
					
					Student s= new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					
					
					
					int r=studentDao.insert(s);
					
					System.out.println(r +" Student Added");
					
					System.out.println("********************************");
					System.out.println();

					break;

				case 2:
                 //display all student
					System.out.println("********************************");
					List<Student> allStudents=studentDao.getAllStudents();
					
					for(Student st : allStudents) {
						System.out.println("ID : " + st.getStudentId());
						System.out.println("name :" + st.getStudentName());
						System.out.println("city : " + st.getStudentCity());
						System.out.println("______________________________");
					}
					
					System.out.println("**************************************");
					break;

				case 3:
					//for get detail of single student
					System.out.println("Enter user id :");
					int userId=Integer.parseInt(br.readLine());
					Student stu=studentDao.getStudent(userId);
					System.out.println("ID : " + stu.getStudentId());
					System.out.println("name :" + stu.getStudentName());
					System.out.println("city : " + stu.getStudentCity());
					System.out.println("______________________________");
					

					break;

				case 4:
					//for delete student
					System.out.println("Enter user id :");
					int Id=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(Id);
					System.out.println("data deleted");
					
					

					break;

				case 5:
					//for update student

					break;

				case 6:
					//for exit
					go=false; 

					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid input try another one!!");
				System.out.println(e.getMessage());
			}
		}
		
		

	}
}
