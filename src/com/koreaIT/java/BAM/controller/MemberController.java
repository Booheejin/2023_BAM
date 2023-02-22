package com.koreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.Util;

public class MemberController extends Controller{
	
	private List<Member> members;
	private Scanner sc;
	private int lastMemberId;
	
	
	
	public MemberController(Scanner sc) {
		this.members = new ArrayList<>();
		this.sc =sc;
		this.lastMemberId = 0;
	}
	
	@Override
	public void doAction(String cmd, String methodName) {
	
		
		switch(methodName) {
		case "join":
			doJoin();
			break;
		default:
	    	System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}


	int lastArticleId;
	
	
	private void doJoin(){
		
		int id = lastArticleId +1;
		lastArticleId = id;
		String regDate= Util.getDate();
		
		String loginid = null;
		
		while(true) {
			System.out.printf("로그인 아이디 : ");
			loginid = sc.nextLine().trim();;
			
			if(namediDupChk(loginid) == false ) {
				System.out.printf("%s은(는) 이미 사용중인 아이디 입니다.\n",loginid);
				continue;
			}
			System.out.println("사용가능한  아이디 입니다.");
		
			break;
		}
		
		String ps = null;
		String pscid = null;
		
		while(true) {
			
			System.out.printf("로그인 비밀번호 : ");
			ps = sc.nextLine().trim();;
			
			System.out.printf("로그인 비밀번호 확인 : ");
			pscid = sc.nextLine().trim();;
			
			if(ps.equals(pscid) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			
			break;
		}
		
		System.out.printf("이름 : ");
		String name = sc.nextLine().trim();;
		
		Member member = new Member(id,regDate,loginid, ps, pscid, name);
		
		members.add(member);
		
		System.out.printf("%s 회원님 환영합니다.\n", loginid);
	}

	private boolean namediDupChk(String loginid) {
		
		for(Member member: members) {
			if(member.nameid.equals(loginid)) {
				return false;
			}
		}
		return true;
	}

	

	

	
}
