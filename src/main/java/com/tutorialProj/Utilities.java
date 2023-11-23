package com.tutorialProj;

import java.util.Date;

public class Utilities {

	public static String generateemailwithTime() {
		Date date = new Date();
		String time = date.toString().replace(":", "_").replace(" ", "_");
		return time+"@gmail.com";
	}
}
