package org.metatransapps.apps.stroop.cfg.mode;


import org.metatransapps.commons.cfg.ConfigurationUtils_Base;
import org.metatransapps.commons.cfg.IConfigurationEntry;


public class ConfigurationUtils_Mode extends ConfigurationUtils_Base {
	
	
	private static final String TAG_NAME = ConfigurationUtils_Mode.class.getName();
	
	
	public static final int MODE_GETMEANING 	= 1;
	public static final int MODE_GETCOLOR 		= 2;
	
	
	public static ConfigurationUtils_Base getInstance() {
		return getInstance(TAG_NAME);
	}

	
	public static void createInstance() {
		
		IConfigurationEntry[] cfgs_difficulties = new IConfigurationEntry[] { 
				
				new Config_Mode_PutColor(),
				new Config_Mode_Word(),
			};
		
		createInstance(TAG_NAME, new ConfigurationUtils_Mode(), cfgs_difficulties);
	}
}
