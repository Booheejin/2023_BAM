package com.koreaIT.java.BAM.dto;

public class Member extends Dto {
	public String loginid;
	public String ps;
	public String pscid;
	public String name;
	
	
	
	public Member(int id ,String regDate,String loginid,String ps, String pscid ,String name){
		this.id = id;
		this.regDate= regDate;
		this.loginid = loginid;
		this.ps = ps;
		this.pscid = pscid;
		this.name = name;
	}

	
}
