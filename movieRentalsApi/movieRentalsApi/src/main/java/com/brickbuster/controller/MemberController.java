package com.brickbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brickbuster.entity.Member;
import com.brickbuster.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createMember(@RequestBody Member member) {
		return new ResponseEntity<Object>(service.createMember(member), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getMember(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getMemberById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getMembers() {
		return new ResponseEntity<Object>(service.getMembers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMember(@PathVariable Long id) {
		try {
			service.deleteMember(id);
			return new ResponseEntity<Object>("Deleted member with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMember(@RequestBody Member member, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateMember(id, member), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
