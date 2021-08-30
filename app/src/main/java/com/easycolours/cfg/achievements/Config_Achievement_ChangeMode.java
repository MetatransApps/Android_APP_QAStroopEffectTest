package com.easycolours.cfg.achievements;


import org.metatransapps.commons.cfg.achievements.Config_Achievement_Base;

import com.easycolours.lib.R;


public class Config_Achievement_ChangeMode extends Config_Achievement_Base {
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_CHANGE_MODE;
	}
	
	
	@Override
	public int geIDReference() {
		return R.string.achievement_id_change_mode;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_change_mode;
	}
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_change_mode;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_change_mode;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_change_mode;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_change_mode;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_change_mode;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
