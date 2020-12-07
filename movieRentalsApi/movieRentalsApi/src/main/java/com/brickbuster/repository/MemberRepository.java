package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{

}
