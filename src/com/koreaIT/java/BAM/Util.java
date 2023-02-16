package com.koreaIT.java.BAM;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static void main(String[]args) {
		Date date= new Date();
		SimpleDateFormat foramtter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		
		System.out.println(foramtter.format(date));
		
	}
}
