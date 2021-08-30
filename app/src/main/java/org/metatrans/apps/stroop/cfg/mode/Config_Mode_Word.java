package org.metatrans.apps.stroop.cfg.mode;


import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.cfg.ConfigurationEntry_Base;


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
