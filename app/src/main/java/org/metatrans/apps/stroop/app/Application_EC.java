package org.metatrans.apps.stroop.app;


import org.metatrans.apps.stroop.achievements.AchievementsManager;
import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.apps.stroop.events.EventsManager_EC;
import org.metatrans.apps.stroop.lib.BuildConfig;
import org.metatrans.apps.stroop.main.Activity_Result;
import org.metatrans.apps.stroop.model.UserSettings;
import org.metatrans.commons.achievements.IAchievementsManager;
import org.metatrans.commons.app.Application_Base_Ads;
import org.metatrans.commons.cfg.appstore.IAppStore;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import org.metatrans.commons.engagement.ILeaderboardsProvider;
import org.metatrans.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.model.GameData_Base;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.questionnaire.model.GameData;
import org.metatrans.commons.ui.utils.DebugUtils;


public abstract class Application_EC extends Application_Base_Ads {


	private static final String[] KEYWORDS = new String[] {"colors", "colours"};
	
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
		
		ConfigurationUtils_Colours.class.getName();
		ConfigurationUtils_Mode.createInstance();
		
		ConfigurationUtils_Base_MenuMain.createInstance();
	}

	
	@Override
	protected ILeaderboardsProvider createLeaderboardsProvider() {
		return new LeaderboardsProvider_Base(this, Activity_Result.class);
	}
	
	
	@Override
	public GameData_Base createGameDataObject() {
		return new GameData();
	}
	
	
	@Override
	public IAppStore getAppStore() {
		return IAppStore.OBJ_GOOGLE;
	}
	
	
	public String[] getKeywords() {
		return KEYWORDS;
	}
	
	
	@Override
	protected IAchievementsManager createAchievementsManager() {
		return new AchievementsManager(this);
	}
	
	
	@Override
	protected IEventsManager createEventsManager() {
		return new EventsManager_EC(getExecutor(), getAnalytics(), getAchievementsManager());
	}
	
	
	@Override
	public boolean isTestMode() {
		boolean productiveMode = !BuildConfig.DEBUG || !DebugUtils.isDebuggable(this);
		return !productiveMode;
	}


	@Override
	protected UserSettings_Base createUserSettingsObject() {
		return new UserSettings();
	}
}
