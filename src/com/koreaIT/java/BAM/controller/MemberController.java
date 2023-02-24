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
		this.setLastMemberId(0);
	}
	
	@Override
	public void doAction(String cmd, String methodName) {
	
		
		switch(methodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		case "profile":
			doProfile();
			break;
		default:
	    	System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}


	int lastArticleId;
	
	
	private void doJoin(){
		
		if(isLogined()) {
			System.out.println("로그아웃 후 이용해주세요.");
			return;
		}
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
	
	private void doLogin(){
		
		String loginid = null;
		String ps = null;
		
		while(true) {
			
			if(isLogined()) {
				System.out.println("이미 로그인 중입니다.");
				return;
			}
			
			System.out.printf("로그인 아이디 : ");
			loginid = sc.nextLine().trim();;
			
			System.out.printf("로그인 비밀번호 : ");
			ps = sc.nextLine().trim();;
			
			Member member = loginDupChk(loginid);
			
			if (member == null) {
				System.out.println("존재 하지 않는 아이디 입니다");
				continue;
			}
			
			if(member.ps.equals(ps) == false) {	
				System.out.println("비밀번호를 확인해주세요.");
				continue;
			}
			
			loginedMember = member;
			
			System.out.printf("로그인 성공! %s 님 환영합니다\n",member.name);
			break;
		}
	}

	private void doProfile() {
		if(isLogined() == false) {
			System.out.println("로그인 해주세요.");
			return;
		}
		System.out.println("== 내 정보 ==");
		System.out.printf("로그인 아이디 : %s\n",loginedMember.loginid);
		System.out.printf("이름: %s\n",loginedMember.name);
	}

	public void doLogout() {
		if(isLogined()  == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		loginedMember = null;
		
		System.out.println("로그아웃 되었습니다");
	}
	
	private Member loginDupChk(String loginid) {
		
		for(Member member: members) {
			if(member.loginid.equals(loginid)) {
				
				return member;
			}
		}
		
		return null;
	}
	
	private boolean namediDupChk(String loginid) {
		
		Member member = loginDupChk(loginid);

		if (member == null) {
			return true;
		}
		
		return false;
	}

	public int getLastMemberId() {
		return lastMemberId;
	}

	public void setLastMemberId(int lastMemberId) {
		this.lastMemberId = lastMemberId;
	}
	public void makeTestData() {
		System.out.println("회원 테스트 데이터를 생성합니다.");
		members.add(new Member(1,Util.getDate(),"test1","test1","test1","test1"));
		members.add(new Member(2,Util.getDate(),"test2","test2","test2","test2"));
		members.add(new Member(3,Util.getDate(),"test3","test3","test3","test3"));
		
	}
	
}
