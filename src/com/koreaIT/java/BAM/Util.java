package com.koreaIT.java.BAM;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String getDate() {
		
		Date date= new Date();
		
		SimpleDateFormat foramtter = new SimpleDateFormat("yyyy-dd-MM HH:mm");
		
//		System.out.println(foramtter.format(date));
		
		return foramtter.format(date);
		
	}
}
