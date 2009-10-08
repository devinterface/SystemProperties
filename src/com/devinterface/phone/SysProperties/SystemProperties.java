package com.devinterface.phone.SysProperties;


import javax.microedition.midlet.*;


public class SystemProperties extends MIDlet  {
	
	/**
	 * method called when the midlet is executed
	 */
	public void startApp() {

		try {
			
			GetProperties gProp = new GetProperties(this);			
			
		} catch (Exception ex) {
			System.out.println("Exception catched:" + ex);
		}
	}


	public void pauseApp() {
 
	}

	

	public void destroyApp(boolean bool) {

	}

}
