package com.koreaIT.java.BAM.service;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dao.MemberDao;
import com.koreaIT.java.BAM.dto.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public  MemberService() {
		this.memberDao = Container.memberDao;
	}
	public int getLastId() {
		
		return memberDao.getLastId();
	}

	public boolean namediDupChk(String loginid) {
		
		return memberDao.namediDupChk(loginid);
	}

	public void add(Member member) {
		memberDao.add(member);
		
	}

	public Member loginDupChk(String loginid) {
		
		return memberDao.loginDupChk(loginid);
	}

	public String getWriterName(int memberId) {
		
		return memberDao.getWrtierName(memberId);
	}

}
