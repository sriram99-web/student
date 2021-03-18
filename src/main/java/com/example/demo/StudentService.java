package com.example.demo;

import java.util.List;

import com.example.demo.Student;
import com.example.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

 
@Service
public class StudentService implements IService {
 
 @Autowired
 private StudentRepository repo;
 
    public List<Student> listAll() {
    	
        return repo.findAll();
    }
     
    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
//    @Override
//    public List<Student> findPaginated(int pageNo,int pageSize){
//    	//System.out.print("aasffffffffffffsd");
//    	Pageable paging=PageRequest.of(pageNo, pageSize);
//    	//System.out.println("aasffffffffffffsd");
//    	Page<Student> pagedRes=repo.findAll(paging);
//    	//System.out.print("ffffffffffffsd");
//    	return pagedRes.toList();
//    	
//    }
    
//    @Override
//    public List<Student> findPageSorted(int pageNo,int pageSize,String sortBy){
//    	
//    	Pageable paging=PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
//    	Page<Student> pagedRes=repo.findAll(paging);
//    	return pagedRes.toList();
//    	
//    }
    
    
    
    
   
    
 
}
