package com.example.redis.daoImpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.example.redis.dao.IStudentDao;
import com.example.redis.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private final String KEY = "STUDENT";
	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Student> operation;

	@Override
	public void addStudent(Student st) {
		operation.putIfAbsent(KEY, st.getId(), st);
	}

	@Override
	public void modifyStudent(Student st) {

		operation.put(KEY, st.getId(), st);
	}

	@Override
	public Student getStudent(int id) {

		return operation.get(KEY, id);
	}

	@Override
	public void removeStudent(int id) {
		operation.delete(KEY, id);

	}

	@Override 
	public Map<Integer, Student> getAllStudent() {
		// TODO Auto-generated method stub
		return operation.entries(KEY);
	}

}
