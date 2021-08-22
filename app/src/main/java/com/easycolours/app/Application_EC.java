package com.easycolours.app;


import com.apps.mobile.android.commons.achievements.IAchievementsManager;
import com.apps.mobile.android.commons.ads.api.IAdsConfigurations;
import com.apps.mobile.android.commons.app.Application_Base_Ads;
import com.apps.mobile.android.commons.cfg.app.IAppConfig;
import com.apps.mobile.android.commons.cfg.appstore.IAppStore;
import com.apps.mobile.android.commons.cfg.colours.ConfigurationUtils_Colours;
import com.apps.mobile.android.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import com.apps.mobile.android.commons.engagement.ILeaderboardsProvider;
import com.apps.mobile.android.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import com.apps.mobile.android.commons.events.api.IEventsManager;
import com.apps.mobile.android.commons.model.GameData_Base;
import com.apps.mobile.android.commons.model.UserSettings_Base;
import com.apps.mobile.android.commons.questionnaire.model.GameData;
import com.apps.mobile.android.commons.ui.utils.DebugUtils;
import com.easycolours.lib.BuildConfig;
import com.easycolours.lib.R;
import com.easycolours.achievements.AchievementsManager;
import com.easycolours.cfg.app.AppConfig_EC;
import com.easycolours.cfg.mode.ConfigurationUtils_Mode;
import com.easycolours.events.EventsManager_EC;
import com.easycolours.main.Activity_Result;
import com.easycolours.model.UserSettings;


public abstract class Application_EC extends Application_Base_Ads {
	
	
	protected IAppConfig appConfig = new AppConfig_EC();
	
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
	public IAppConfig getAppConfig() {
		return appConfig;
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
