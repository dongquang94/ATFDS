package main.java.fds.utils;
import java.util.*;
import java.io.*;

public class SimpleLogger {

	//----------------------------------------------------------------------------//
	
	
	public static void main(String [] args) {
		if (args.length != 3) {
			System.out.println("USAGE: C:\\>java SimpleLogger LOG_FILE_PATH_AND_NAME, CONTEXT, MESSAGE");
		}
		else {
			logMessage(args[0], args[1], (Object)args[2]);
		}
	} // end method

	//----------------------------------------------------------------------------

	public static void logMessage(String sLogFileName, 
						String sContext, 
						Object oMessage) {

		String sHour = "" + Calendar.getInstance().get(Calendar.HOUR);
		String sMinute = "" + Calendar.getInstance().get(Calendar.MINUTE);
		String sAmPm = "AM";
		String sMessage = "";
		boolean bMessageIsThrowableType = false;
		java.lang.Throwable oThrowable = null;
		String sCrLf = System.getProperty("line.separator");
		RandomAccessFile oRandomAccessFile = null;

		// Format the message.

		if (sHour.length() == 1) {
			sHour = "0" + sHour;
		}
		if (sHour.equals("00")) {
			sHour = "12";
		}
		if (sMinute.length() == 1) {
			sMinute = "0" + sMinute;
		}
		if (Calendar.getInstance().get(Calendar.AM_PM) == 1) {
			sAmPm = "PM";
		}

		sMessage = "[" 
			+ sContext 
			+ "]" 
			+ " " 
			+ "[@ " 
			+ new Date().toString()
			+ "] ";

		// If the oMessage is a Throwable type, get its full stack trace.
		try {
			oThrowable = (java.lang.Throwable)oMessage;
			bMessageIsThrowableType = true;
		}
		catch (ClassCastException oClassCastException) { // This is not an error!

			bMessageIsThrowableType = false;
		}

		if (bMessageIsThrowableType) {

			StackTraceElement[] oStackTraceElementsArray = oThrowable.getStackTrace();
			String sStackTrace = "EXCEPTION CAUGHT!" + sCrLf;
			sStackTrace += ("\tCAUSE: " + oThrowable.getCause() + sCrLf);
			sStackTrace += ("\tMESSAGE: " + oThrowable.getMessage() + sCrLf);
			sStackTrace += ("\tSTRING: " + oThrowable.toString() + sCrLf);
			sStackTrace += ("\tSTACK TRACE:\n");
			for (int i = 0; i < oStackTraceElementsArray.length; i++) {
				sStackTrace += ("\t\t" + oStackTraceElementsArray[i].toString() + sCrLf);
			}
			sMessage += sStackTrace;
		}
		else {
			sMessage += oMessage.toString();
		}

		// Append CrLf.
		sMessage += sCrLf;

		try {
			if (sLogFileName != null) {
				oRandomAccessFile = new RandomAccessFile(sLogFileName, "rws");
				oRandomAccessFile.seek(oRandomAccessFile.length());
				oRandomAccessFile.writeBytes(sMessage);
			}
		}
		catch (Exception oException) {
			oException.printStackTrace();
		}
		finally {
			try {
				oRandomAccessFile.close();
			}
			catch (Exception oException) 
			{
				;
			}
		}		

	} // end method

	//----------------------------------------------------------------------------

} // end class
