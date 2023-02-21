package com.koreaIT.java.BAM.dto;

public class Member extends Dto {
	public String nameid;
	public String ps;
	public String pscid;
	public String name;
	
	
	public Member(int id ,String regDate,String nameid,String ps, String pscid,String name ){
		this.id = id;
		this.regDate= regDate;
		this.nameid = nameid;
		this.ps = ps;
		this.pscid = pscid;
		this.name = name;
	}

	
}
