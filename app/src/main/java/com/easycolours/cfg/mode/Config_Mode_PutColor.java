package com.easycolours.cfg.mode;


import org.metatransapps.commons.cfg.ConfigurationEntry_Base;

import com.easycolours.lib.R;


public class Config_Mode_PutColor extends ConfigurationEntry_Base {
	
	
	@Override
	public int getID() {
		return ConfigurationUtils_Mode.MODE_GETMEANING;
	}
	
	
	@Override
	public int getName() {
		return R.string.mode_colours_name;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_arc_short_i;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.mode_colours_desc;
	}
}
