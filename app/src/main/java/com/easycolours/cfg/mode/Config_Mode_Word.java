package com.easycolours.cfg.mode;


import com.apps.mobile.android.commons.cfg.ConfigurationEntry_Base;
import com.easycolours.lib.R;


public class Config_Mode_Word extends ConfigurationEntry_Base {
	
	
	@Override
	public int getID() {
		return ConfigurationUtils_Mode.MODE_GETCOLOR;
	}
	
	
	@Override
	public int getName() {
		return R.string.mode_words_name;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_letters;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.mode_words_desc;
	}
}
