package org.metatransapps.apps.stroop.cfg.achievements;


import org.metatransapps.apps.stroop.lib.R;
import org.metatransapps.commons.cfg.achievements.Config_Achievement_Base;


public class Config_Achievement_Correct_GetColor extends Config_Achievement_Base {
	
	
	public static int CFG_ACHIEVEMENT_CORRECT_GETCOLOR 		= 1000;
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_CORRECT_GETCOLOR;
	}
	
	
	@Override
	public int geIDReference() {
		return R.string.achievement_id_correct_getcolor;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_correct_getcolor;
	}

	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_correct_getcolor;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_correct_getcolor;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_correct_getcolor;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_correct_getcolor;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_correct_getcolorputmeaning;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
