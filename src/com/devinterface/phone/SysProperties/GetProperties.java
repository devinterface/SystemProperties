package com.devinterface.phone.SysProperties;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;


public class GetProperties extends Form implements CommandListener {
	
	Form frm;
	
	SystemProperties sysProp;
	
	Image image;

	private Command ExitCmd = null;
	private Command UpdateCmd = null;
	

	GetProperties(SystemProperties infoMidlet) {
		super("DevInterface - Phone HW/SW info");
		this.sysProp = infoMidlet;
		Display.getDisplay(this.sysProp).setCurrent(this);

		ExitCmd = new Command("Exit", Command.EXIT, 1);
		UpdateCmd = new Command("Refresh", Command.OK, 1);	
		//this.addCommand(UpdateCmd);
		this.addCommand(ExitCmd);
		this.setCommandListener(this);

		frm = new Form("System Properties");
		try {
			image = Image.createImage("/devInterface2.png");
		} catch (Exception e) {
		}

		showProperties();
		frm.addCommand(UpdateCmd);
		frm.addCommand(ExitCmd);
		frm.setCommandListener(this);
	}
	
	public void showProperties()
	{
        
		frm.append(image);
		frm.append("\n");
		frm.append("Free RAM Memory: \n" +System.getProperty("com.nokia.memoryramfree") +"\n\n");		
		frm.append("Video capture support: \n" +System.getProperty("supports.video.capture")+"\n\n");
		frm.append("Battery Level: \n" +System.getProperty("com.nokia.mid.batterylevel")+"\n\n");
		frm.append("Phone's IMEI: \n" +System.getProperty("com.nokia.mid.imei")+"\n\n");	
		frm.append("Microedition Platform: \n" +System.getProperty("microedition.platform")+"\n\n");
		frm.append("Network Availability: \n" +System.getProperty("com.nokia.mid.networkavailability")+"\n\n");
		frm.append("Signal Strength: \n" +System.getProperty("com.nokia.mid.networksignal")+"\n\n");
		
		Display.getDisplay(this.sysProp).setCurrent(frm);
	}
	

	public void commandAction(Command com, Displayable dsb) {
		if (com.equals(this.ExitCmd)) {
			this.sysProp.notifyDestroyed();
		} else if (com.equals(this.UpdateCmd)){
			frm.deleteAll();
			showProperties();
		}
	}
	
}
