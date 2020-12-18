package com.brickbuster.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.Member;
import com.brickbuster.repository.MemberRepository;

@Service
public class MemberService {

	private static final Logger Logger = LogManager.getLogger(MemberService.class);

	@Autowired
	private MemberRepository repo;

	public Member createMember(Member member) {
		return repo.save(member);
	}

	public Member getMemberById(Long id) throws Exception {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to retrieve member: " + id, e);
			throw e;
		}
	}

	public Iterable<Member> getMembers() {
		return repo.findAll();
	}

	public void deleteMember(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to delete member: " + id, e);
			throw new Exception("Unable to delete member.");
		}
	}

	public Member updateMember(Long id, Member member) throws Exception {
		Member oldMember = repo.findById(id).get();
		try {
			if (member.getFirstName() != null) {
				oldMember.setFirstName(member.getFirstName());
			}

			else if (member.getLastName() != null) {
				oldMember.setLastName(member.getLastName());
			}

			else if (member.getMembershipLevel() != null) {
				oldMember.setMembershipLevel(member.getMembershipLevel());
			}
			return repo.save(oldMember);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to update member: " + id, e);
			throw new Exception("Unable to update member.");
		}
	}
}
