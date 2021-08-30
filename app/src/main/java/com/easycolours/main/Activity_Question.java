package com.easycolours.main;


import org.metatransapps.commons.Activity_Base;
import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatransapps.commons.cfg.colours.IConfigurationColours;
import org.metatransapps.commons.questionnaire.api.IConfigurationQuestion;
import org.metatransapps.commons.questionnaire.main.OnTouchListener_Question;
import org.metatransapps.commons.questionnaire.main.View_Question;
import org.metatransapps.commons.storage.StorageUtils;

import com.easycolours.lib.R;
import com.easycolours.logic.GeneratorsFactory;
import com.easycolours.menu.Activity_Menu_Main;
import com.easycolours.model.UserSettings;

import android.content.res.Configuration;
import android.view.Gravity;
import android.view.View;


public class Activity_Question extends org.metatransapps.commons.questionnaire.main.Activity_Question {
	
	
	/*@Override
	protected void showLeaderBoards() {
	
		if (((Application_Base_Ads)getApplication()).getSocialProvider().isConnected()) {
			
			if (getGameData().getGameResult().count_incorrect == 0) {
				long time = getGameData().getGameResult().time;
				((Application_Base_Ads)getApplication()).getSocialProvider().submitLeaderboardScore(getUserSettings().modeID, time);
			}
			
			GameResult best = getBestResults().getResult(getUserSettings().modeID);
			if (best != null) {
				if (best.count_incorrect == 0) {
					((Application_Base_Ads)getApplication()).getSocialProvider().submitLeaderboardScore(getUserSettings().modeID, best.time);
				}
			}
			
			((Application_Base_Ads)getApplication()).getSocialProvider().openLeaderboard(getUserSettings().modeID);
		}
	}*/
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER2;
	}

	@Override
	protected int getGravity() {
		return Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
	}
	
	@Override
	public void setNextLevel() {
		//Do nothing
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		boolean left_handed = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
		return left_handed ? R.drawable.ic_colours_tube : R.drawable.ic_colours_tube;
	}
	
	
	@Override
	protected View createView() {
		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(getUserSettings().uiColoursID);
		View_Question view = new View_Question(this, coloursCfg, getGameData());
		view.setId(VIEW_ID);
		view.setOnTouchListener(new OnTouchListener_Question(view));
		return view;
	}
	
	
	@Override
	protected IConfigurationQuestion getNextQuestion() {
		IConfigurationQuestion next_question = GeneratorsFactory.getGenerator_ByType(this.getApplication(), getUserSettings().modeID).nextQuestion(getGameData());
		return next_question;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu() {
		return Activity_Menu_Main.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Result() {
		return Activity_Result.class;
	}
	
	
	@Override
	public UserSettings getUserSettings() {
		UserSettings settings = (UserSettings) StorageUtils.readStorage(this, UserSettings.FILE_NAME_USER_SETTINGS);
		if (settings == null) {
			settings = new UserSettings();
			StorageUtils.writeStore(this, UserSettings.FILE_NAME_USER_SETTINGS, settings);
			settings = (UserSettings) StorageUtils.readStorage(this, UserSettings.FILE_NAME_USER_SETTINGS);
		}
		return settings;
	}
}
