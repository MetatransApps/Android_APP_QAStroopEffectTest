package org.metatransapps.apps.stroop.achievements;


import android.content.Context;

import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_ChangeColours;
import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_ChangeMode;
import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_Correct_GetColor;
import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_Correct_GetMeaning;
import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_Invite3Friends;
import org.metatransapps.apps.stroop.cfg.achievements.Config_Achievement_StopPiecesOnLoading;
import org.metatransapps.commons.achievements.AchievementsManager_Base;
import org.metatransapps.commons.app.Application_Base;
import org.metatransapps.commons.cfg.achievements.IConfigurationAchievements;
import org.metatransapps.commons.ui.Toast_Base;


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
