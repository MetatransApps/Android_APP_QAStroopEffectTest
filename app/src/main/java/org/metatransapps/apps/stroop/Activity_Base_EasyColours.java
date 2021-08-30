package org.metatransapps.apps.stroop;


import org.metatransapps.apps.stroop.lib.R;
import org.metatransapps.commons.questionnaire.Activity_Base_Questionnaire;

import android.content.res.Configuration;
import android.widget.FrameLayout;


public class Activity_Base_EasyColours extends Activity_Base_Questionnaire {
	
	
	@Override
	protected String getBannerName() {
		return null;
	}
	
	
	@Override
	protected FrameLayout getFrame() {
		return null;
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		boolean left_handed = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
		return left_handed ? R.drawable.ic_colours_tube : R.drawable.ic_colours_tube;
	}
}
