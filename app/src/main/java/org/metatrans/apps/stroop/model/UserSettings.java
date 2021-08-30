package org.metatrans.apps.stroop.model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.commons.cfg.colours.IConfigurationColours;


public class UserSettings extends org.metatrans.commons.questionnaire.model.UserSettings {
	
	
	private static final long serialVersionUID = 7288403882626554342L;
	
	
	public static final int DEFAULT_COUNT_QUESTIONS = 50;
	
	
	public UserSettings() {
		
		super();
		
		uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_PETROL;
		modeID 				= ConfigurationUtils_Mode.MODE_GETMEANING;
		countQuestions 		= DEFAULT_COUNT_QUESTIONS;
		
		//fixFields("constructor");
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
	    fixFields("writeObject");
	    
	    // default serialization 
	    oos.defaultWriteObject();
	}
	

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
	    
	    // default deserialization
	    ois.defaultReadObject();
	    
	    fixFields("readObject");
	}
	
	
	private void fixFields(String op) {
		if (uiColoursID == 0) {
	    	uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_PETROL;
	    	System.out.println("UserSettings: " + op + " - updating colour id");
	    }
	    
		if (modeID == 0) {
			modeID = ConfigurationUtils_Mode.MODE_GETMEANING;
		}
		
	    if (countQuestions == 0) {
	    	countQuestions 		= DEFAULT_COUNT_QUESTIONS;
	    	System.out.println("UserSettings: " + op + " - updating questions count");
	    }
	}
}
