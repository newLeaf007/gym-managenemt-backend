package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Member;


public interface MemberRepo extends JpaRepository<Member, Integer>  {
	
	//find by name
	List<Member> findByName(String name);

}
