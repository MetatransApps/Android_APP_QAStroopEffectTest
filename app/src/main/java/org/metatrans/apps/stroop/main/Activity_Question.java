package org.metatrans.apps.stroop.main;


import org.metatrans.apps.stroop.lib.R;
import org.metatrans.apps.stroop.logic.GeneratorsFactory;
import org.metatrans.apps.stroop.menu.Activity_Menu_Main;
import org.metatrans.apps.stroop.model.UserSettings;
import org.metatrans.commons.Activity_Base;
import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion;
import org.metatrans.commons.questionnaire.main.OnTouchListener_Question;
import org.metatrans.commons.questionnaire.main.View_Question;
import org.metatrans.commons.questionnaire.model.GameData;
import org.metatrans.commons.storage.StorageUtils;

import android.content.res.Configuration;
import android.view.View;


public class Activity_Question extends org.metatrans.commons.questionnaire.main.Activity_Question {


	@Override
	public void setNextLevel() {
		//Do nothing
	}


	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER2;
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

		view.setOnTouchListener(new OnTouchListener_Question(view) {
			@Override
			public int getSFX_AnswerCorrect_ResID() {
				return R.raw.sfx_answer_correct;
			}

			@Override
			public int getSFX_AnswerWrong_ResID() {
				return R.raw.sfx_answer_wrong;
			}
		});

		return view;
	}
	
	
	@Override
	protected IConfigurationQuestion getNextQuestion(GameData gameData) {

		IConfigurationQuestion next_question = GeneratorsFactory.getGenerator_ByType(this.getApplication(), getUserSettings().modeID).nextQuestion(gameData);

		return next_question;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu() {
		return Activity_Menu_Main.class;
	}


	/*@Override
	protected Class<? extends Activity_Base> getActivityClass_Result() {
		return Activity_Result.class;
	}*/
	
	
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


	@Override
	public void onResume() {

		super.onResume();

		Application_Base.getInstance().getMelodiesManager().setMelody(Application_Base.getInstance().getUserSettings().melody_cfg_id);
	}


	@Override
	public void onPause() {

		super.onPause();

		Application_Base.getInstance().getMelodiesManager().stop();
	}


	@Override
	public int getSFX_GameStart_ResID() {

		return R.raw.sfx_game_start;
	}


	@Override
	public int getSFX_GameEnd_ResID() {

		return R.raw.sfx_game_end;
	}
}
