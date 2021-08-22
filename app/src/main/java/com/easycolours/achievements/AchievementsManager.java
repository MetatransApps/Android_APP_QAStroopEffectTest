package com.easycolours.achievements;


import android.content.Context;

import com.apps.mobile.android.commons.achievements.AchievementsManager_Base;
import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.cfg.achievements.IConfigurationAchievements;
import com.apps.mobile.android.commons.ui.Toast_Base;
import com.easycolours.cfg.achievements.Config_Achievement_ChangeColours;
import com.easycolours.cfg.achievements.Config_Achievement_ChangeMode;
import com.easycolours.cfg.achievements.Config_Achievement_Correct_GetColor;
import com.easycolours.cfg.achievements.Config_Achievement_Correct_GetMeaning;
import com.easycolours.cfg.achievements.Config_Achievement_Invite3Friends;
import com.easycolours.cfg.achievements.Config_Achievement_StopPiecesOnLoading;


public class AchievementsManager extends AchievementsManager_Base {
	
	
	private static IConfigurationAchievements[] ALL_CFGs;
	
	
	public AchievementsManager(Application_Base app) {
		
		super(app);
		
		ALL_CFGs = new IConfigurationAchievements[] {
			 	new Config_Achievement_Invite3Friends(),
			 	new Config_Achievement_StopPiecesOnLoading(),
				new Config_Achievement_ChangeColours(),
				new Config_Achievement_ChangeMode(),
				new Config_Achievement_Correct_GetColor(),
				new Config_Achievement_Correct_GetMeaning(),
			};
	}
	
	
	@Override
	public IConfigurationAchievements[] getAll() {
		return ALL_CFGs;
	}
	
	
	@Override
	public void sentNotification(Context context, Integer achievementID) {
		//Do Nothing
		Toast_Base.showToast_InCenter(context, "Notification: New Achievement " + getConfigByID(achievementID).getName());
	}
}
