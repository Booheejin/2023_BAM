package com.koreaIT.java.BAM.service;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Member;

public class MemberService {

	public int getLastId() {
		
		return Container.memberDao.getLastId();
	}

	public boolean namediDupChk(String loginid) {
		
		return Container.memberDao.namediDupChk(loginid);
	}

	public void add(Member member) {
		Container.memberDao.add(member);
		
	}

	public Member loginDupChk(String loginid) {
		
		return Container.memberDao.loginDupChk(loginid);
	}

	public String getWriterName(int memberId) {
		
		return Container.memberDao.getWrtierName(memberId);
	}

}
