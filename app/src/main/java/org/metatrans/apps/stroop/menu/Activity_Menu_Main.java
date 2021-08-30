package org.metatrans.apps.stroop.menu;


import java.util.List;

import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.achievements.IAchievementsManager;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Base;
import org.metatrans.commons.cfg.menu.IConfigurationMenu_Main;
import org.metatrans.commons.engagement.achievements.Activity_Scores;
import org.metatrans.commons.events.api.IEvent_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.menu.Activity_Menu_Main_Base;

import android.content.Intent;


public class Activity_Menu_Main extends Activity_Menu_Main_Base {
	
	
	public static int CFG_MENU_MODES			 		= 15;
	public static int CFG_MENU_SCORES			 		= 16;
	
	
	@Override
	protected List<IConfigurationMenu_Main> getEntries() {
		
		
		List<IConfigurationMenu_Main> entries = super.getEntries();
		
		//Add on 4 or 3 position in order to leave 'Invite Friends' on position 0 and other options on positions 1, 2, 3.
		int addIndex = 3;
		if (Application_Base.getInstance().getApp_Me().getPaidVersion() != null) {
			addIndex = 4;
		}
		
		entries.add(addIndex, new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.scores;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_scores;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_SCORES;
			}
			
			@Override
			public String getDescription_String() {
				IAchievementsManager achievementsManager = Application_Base.getInstance().getAchievementsManager();
				int scores = achievementsManager.getScores(Application_Base.getInstance());
				return getString(R.string.label_current) + ": " + scores;
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						
						//Scores
						Intent i = new Intent(getApplicationContext(), Activity_Scores.class);
						startActivity(i);
						//finish();
						
						IEventsManager eventsManager = Application_Base.getInstance().getEventsManager();
		            	eventsManager.register(Activity_Menu_Main.this, eventsManager.create(IEvent_Base.MENU_OPERATION, IEvent_Base.MENU_OPERATION_SCORES,
								"MENU_OPERATION", "OPEN_SCORES"));
						
					}
				};
			}
		});
		
		
		entries.add(addIndex, new Config_MenuMain_Base() {
			
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

		entries.remove(entries.size() - 1);
		entries.remove(entries.size() - 1);
		entries.remove(entries.size() - 1);

		return entries;
	}
}
