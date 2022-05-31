package org.metatrans.apps.stroop.menu;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Base;
import org.metatrans.commons.cfg.menu.IConfigurationMenu_Main;

import android.content.Intent;


public class Activity_Menu_Main extends org.metatrans.commons.questionnaire.menu.Activity_Menu_Main {


	public static int CFG_MENU_MODES			 		= 15;
	
	
	@Override
	protected List<IConfigurationMenu_Main> getEntries() {


		List<IConfigurationMenu_Main> result = new ArrayList<IConfigurationMenu_Main>();


		result.add(new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.label_mode;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_creature_turtle_nobackground_4;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_MODES;
			}
			
			@Override
			public String getDescription_String() {
				return getString(R.string.label_current) + ": " + getString(ConfigurationUtils_Mode.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID).getName());
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						
						Intent i = new Intent(getApplicationContext(), Activity_Menu_Mode.class);
						startActivity(i);
						finish();
						
					}
				};
			}
		});


		List<IConfigurationMenu_Main> entries = super.getEntries();


		result.addAll(entries);


		return result;
	}
}
