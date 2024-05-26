package utils;

import java.util.GregorianCalendar;

public class CommonUtils {
	public static final int IMPLICITWAIT_TIME=10;
	public static final int PAGELOAD_TIME=15;
	public String getEmailwithTimeStamp() {
		GregorianCalendar date = new GregorianCalendar();
		return "anusha"+date.toString().replace("","_").replace(":", "_")+"@gmail.com";
	}
	public String getEmailwithTimeStampnano() {
//		GregorianCalendar date = new GregorianCalendar();
		return "anusha"+System.nanoTime()+"@gmail.com";
	}
}
