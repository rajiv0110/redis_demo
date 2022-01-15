package com.example.redis.dao;

import java.util.Map;

import com.example.redis.model.Student;

public interface IStudentDao {

	void addStudent(Student st);

	void modifyStudent(Student st);

	Student getStudent(int id);

	void removeStudent(int id);

	Map<Integer, Student> getAllStudent();

}
