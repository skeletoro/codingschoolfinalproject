package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.brickbuster.entity.Member;


public interface MemberRepository extends CrudRepository<Member, Long>{

}
