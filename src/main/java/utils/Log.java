package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	
	public static Logger Log = LogManager.getLogger(Log.class.getName());
	
	public static void info(String mesaj) {
		Log.info(mesaj);
	}
	
	public static void error(String error) {
		Log.error(error);
	}
	
	public static void error(Throwable error) {
		Log.error(error);
	}
	
	

}
