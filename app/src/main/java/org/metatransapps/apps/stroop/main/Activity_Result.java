package org.metatransapps.apps.stroop.main;


import android.content.res.Configuration;

import org.metatransapps.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatransapps.apps.stroop.lib.R;
import org.metatransapps.apps.stroop.model.UserSettings;
import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.storage.StorageUtils;


public class Activity_Result extends org.metatransapps.commons.questionnaire.main.Activity_Result {
	
	
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
