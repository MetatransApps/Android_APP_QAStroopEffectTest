package com.easycolours.loading;


import com.apps.mobile.android.commons.Activity_Base;
import com.apps.mobile.android.commons.R;
import com.apps.mobile.android.commons.ads.api.IAdsConfiguration;
import com.apps.mobile.android.commons.app.Application_Base_Ads;
import com.apps.mobile.android.commons.cfg.colours.ConfigurationUtils_Colours;
import com.apps.mobile.android.commons.cfg.colours.IConfigurationColours;
import com.apps.mobile.android.commons.loading.View_Loading_Base;
import com.easycolours.main.Activity_Question;
import com.easycolours.menu.Activity_Menu_Mode;


public class Activity_Loading extends com.apps.mobile.android.commons.loading.Activity_Loading_Base_Ads {
	
	
	@Override
	protected Class<? extends Activity_Base> getNextActivityClass() {
		return Activity_Question.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu2() {
		return Activity_Menu_Mode.class;
	}


	@Override
	protected int getText_Menu2() {
		return R.string.label_mode;
	}
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER1;
	}
	
	
	@Override
	protected String getInterstitialName() {
		return IAdsConfiguration.AD_ID_INTERSTITIAL1;
	}
	
	
	@Override
	protected View_Loading_Base getLoadingView() {
		View_Loading view = new View_Loading(this, ((Application_Base_Ads)getApplication()).getUserSettings());
		return view;
	}
	
	
	@Override
	protected IConfigurationColours getColoursCfg() {
		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(((Application_Base_Ads)getApplication()).getUserSettings().uiColoursID);
		return coloursCfg;
	}
}
