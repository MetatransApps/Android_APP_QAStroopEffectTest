package org.metatrans.apps.stroop.cfg.achievements;


import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.cfg.achievements.Config_Achievement_Base;


public class Config_Achievement_Correct_GetMeaning extends Config_Achievement_Base {
	
	
	public static int CFG_ACHIEVEMENT_CORRECT_GETMEANING 		= 1100;
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_CORRECT_GETMEANING;
	}
	
	
	@Override
	public int geIDReference() {
		return R.string.achievement_id_correct_getmeaning;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_correct_getmeaning;
	}

	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_correct_getmeaning;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_correct_getmeaning;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_correct_getmeaning;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_correct_getmeaning;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_correct_getmeaningputcolor;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
