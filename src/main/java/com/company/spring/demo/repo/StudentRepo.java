package com.company.spring.demo.repo;

import com.company.spring.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {


}
