package com.koreaIT.java.BAM.controller;

import java.util.Scanner;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.service.MemberService;
import com.koreaIT.java.BAM.util.Util;

public class MemberController extends Controller{
	
	
	private Scanner sc;
	private int lastMemberId;
	private MemberService memberService;
	
	public MemberController(Scanner sc) {
		
		this.memberService =  Container.memberService;
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
		
		int id = memberService.getLastId();
		
		String regDate= Util.getDate();
		
		String loginid = null;
		
		while(true) {
			System.out.printf("로그인 아이디 : ");
			loginid = sc.nextLine().trim();;
			
			if(memberService.namediDupChk(loginid) == false ) {
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
		
		memberService.add(member);
		
		System.out.printf("%s 회원님 환영합니다.\n", loginid);
	}
	
	private void doLogin(){
		
		String loginid = null;
		String ps = null;
		
		while(true) {
			
			System.out.printf("로그인 아이디 : ");
			loginid = sc.nextLine().trim();
			
			if(loginid.length() == 0) {
				System.out.println("로그인 아이디를 입력해주세요");
				continue;
			}
			while(true) {
				
				System.out.printf("로그인 비밀번호 : ");
				ps = sc.nextLine().trim();
				
				if(ps.length() == 0) {
					System.out.println("로그인 비밀번호를 입력해주세요");
					continue;
				}
				break;
			}
			
			Member member = memberService.loginDupChk(loginid);
			
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
		
		System.out.println("== 내 정보 ==");
		System.out.printf("로그인 아이디 : %s\n",loginedMember.loginid);
		System.out.printf("이름: %s\n",loginedMember.name);
	}

	public void doLogout() {
		
		loginedMember = null;
		
		System.out.println("로그아웃 되었습니다");
	}
	
	
	public int getLastMemberId() {
		return lastMemberId;
	}

	public void setLastMemberId(int lastMemberId) {
		this.lastMemberId = lastMemberId;
	}
	public void makeTestData() {
		System.out.println("회원 테스트 데이터를 생성합니다.");
		memberService.add(new Member(memberService.getLastId(),Util.getDate(),"test1","test1","test1","test1"));
		memberService.add(new Member(memberService.getLastId(),Util.getDate(),"test2","test2","test2","test2"));
		memberService.add(new Member(memberService.getLastId(),Util.getDate(),"test3","test3","test3","test3"));
		
	}
	
}
