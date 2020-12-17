package com.brickbuster.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

	Optional<Member> save(Optional<Member> oldMember);
    Optional<Member> findById(Long id);



}
