package org.metatransapps.apps.stroop.loading;


import org.metatransapps.apps.stroop.main.Activity_Question;
import org.metatransapps.apps.stroop.menu.Activity_Menu_Mode;
import org.metatransapps.commons.Activity_Base;
import org.metatransapps.commons.R;
import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.app.Application_Base_Ads;
import org.metatransapps.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatransapps.commons.cfg.colours.IConfigurationColours;
import org.metatransapps.commons.loading.View_Loading_Base;


public class Activity_Loading extends org.metatransapps.commons.loading.Activity_Loading_Base_Ads {
	
	
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
