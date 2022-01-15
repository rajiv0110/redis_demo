package com.example.redis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.redis.dao.IStudentDao;
import com.example.redis.model.Student;

@Component
public class RediOperationTest implements CommandLineRunner {

	@Autowired
	private IStudentDao stDao;

	@Override
	public void run(String... args) throws Exception {

		stDao.addStudent(new Student(1, "Rohit", "IT"));
		stDao.addStudent(new Student(2, "Virat", "CSE"));
		stDao.addStudent(new Student(3, "Jadeja", "ECE"));
		stDao.addStudent(new Student(4, "Rishab", "MEC"));
		stDao.getAllStudent().forEach((k, v) -> System.out.println("Key" + k + "-----" + "Value" + v));

		System.out.println("--------Removing student-------");
		stDao.removeStudent(4);
		System.out.println("--------After removal-------");
		stDao.getAllStudent().forEach((k, v) -> System.out.println("Key" + k + "-----" + "Value" + v));

		System.out.println("--------Updating-------");
		stDao.modifyStudent(new Student(1, "Sachin", "ECE"));
		System.out.println("--------Final Data-------");
		stDao.getAllStudent().forEach((k, v) -> System.out.println("Key" + k + "-----" + "Value" + v));
	}

}
