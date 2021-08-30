package com.easycolours.menu;


import org.metatransapps.commons.storage.StorageUtils;

import com.easycolours.lib.R;
import com.easycolours.model.UserSettings;

import android.content.res.Configuration;
import android.widget.FrameLayout;


public class Activity_Menu_Colours extends org.metatransapps.commons.questionnaire.menu.Activity_Menu_Colours {
	
	
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
	
	
	@Override
	protected String getBannerName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	protected FrameLayout getFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
