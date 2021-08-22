package com.easycolours.main;


import android.content.res.Configuration;

import com.apps.mobile.android.commons.ads.api.IAdsConfiguration;
import com.apps.mobile.android.commons.storage.StorageUtils;
import com.easycolours.lib.R;
import com.easycolours.cfg.mode.ConfigurationUtils_Mode;
import com.easycolours.model.UserSettings;


public class Activity_Result extends com.apps.mobile.android.commons.questionnaire.main.Activity_Result {
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER3;
	}
	
	
	@Override
	protected String getModeName() {
		return getString(ConfigurationUtils_Mode.getInstance().getConfigByID(getUserSettings().modeID).getName());
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		boolean left_handed = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
		return left_handed ? R.drawable.ic_colours_tube : R.drawable.ic_colours_tube;
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
