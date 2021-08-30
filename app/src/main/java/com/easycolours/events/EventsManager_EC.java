package com.easycolours.events;


import java.util.concurrent.ExecutorService;

import org.metatransapps.commons.achievements.IAchievementsManager;
import org.metatransapps.commons.analytics.IAnalytics;
import org.metatransapps.commons.app.Application_Base;
import org.metatransapps.commons.cfg.achievements.IConfigurationAchievements;
import org.metatransapps.commons.events.EventsManager_Base;
import org.metatransapps.commons.events.api.IEvent_Base;
import org.metatransapps.commons.model.GameData_Base;
import org.metatransapps.commons.model.UserSettings_Base;
import org.metatransapps.commons.questionnaire.model.GameData;

import android.app.Activity;
import android.content.Context;

import com.easycolours.cfg.achievements.Config_Achievement_Correct_GetColor;
import com.easycolours.cfg.achievements.Config_Achievement_Correct_GetMeaning;
import com.easycolours.cfg.mode.ConfigurationUtils_Mode;
import com.easycolours.model.UserSettings;


public class EventsManager_EC extends EventsManager_Base {
	
	
	public static final int WIN_GAME_GETMEANING = 1;
	public static final int WIN_GAME_GETCOLOR 	= 2;
	
	
	private IAchievementsManager achievementsManager;
	
	
	public EventsManager_EC(ExecutorService _executor, IAnalytics _analytics, IAchievementsManager _achievementsManager) {
		
		super(_executor, _analytics);
		
		achievementsManager = _achievementsManager;
	}
	
	
	@Override
	public void handleGameEvents_OnFinish(Activity activity, GameData_Base data1, UserSettings_Base settings1, int gameStatus) {
		
		System.out.println("EventsManager_EC/handleGameEvents_OnFinish: " + "called");
		
		if (data1.isCountedAsCompleted()) {
			System.out.println("EventsManager_EC/handleGameEvents_OnFinish: " + " game is already counted");
			return;			
		}
		
		
		super.handleGameEvents_OnFinish(activity, data1, settings1, gameStatus);
		
		
		GameData data = (GameData) data1;
		UserSettings settings = (UserSettings) settings1;
		
		if (data.count_answered == UserSettings.DEFAULT_COUNT_QUESTIONS
				&& data.count_answered == data.count_correct) {
			
			if (settings.modeID == ConfigurationUtils_Mode.MODE_GETMEANING) {
			
				register(activity, create(IEvent_Base.WIN_GAME, WIN_GAME_GETMEANING, "WIN_GAME", "GETMEANING"));
				
			} else {
				
				register(activity, create(IEvent_Base.WIN_GAME, WIN_GAME_GETCOLOR, "WIN_GAME", "GETCOLOR"));
				
			}
		}
	}
	
	
	@Override
	protected void handleAchievements(Context context, IEvent_Base event) {
		
		
		super.handleAchievements(context, event);
		
		
		if (event.getID() == IEvent_Base.MARKETING && event.getSubID() == IEvent_Base.MARKETING_INVITE_FRIENDS_CLICKED) {
			
			achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_INVITE_3_FRIENDS);
			
		} else if (event.getID() == IEvent_Base.MENU_OPERATION) {
			
			if (event.getSubID() == IEvent_Base.MENU_OPERATION_CHANGE_COLOURS) {
				achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_CHANGE_COLOURS);
				
			} else if (event.getSubID() == IEvent_Base.MENU_OPERATION_CHANGE_MODE) {
				achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_CHANGE_MODE);
			} 
			
		} else if (event.getID() == IEvent_Base.LOADING && event.getSubID() == IEvent_Base.LOADING_STOPPED_PIECES) {
			
			achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_STOP_PIECES);
		
		} else if (event.getID() == IEvent_Base.WIN_GAME) {
			
			if (event.getSubID() == WIN_GAME_GETCOLOR) {
				
				achievementsManager.inc(context, Config_Achievement_Correct_GetColor.CFG_ACHIEVEMENT_CORRECT_GETCOLOR);
				
			} else if (event.getSubID() == WIN_GAME_GETMEANING) {
				
				achievementsManager.inc(context, Config_Achievement_Correct_GetMeaning.CFG_ACHIEVEMENT_CORRECT_GETMEANING);
			} 
			
		} else {
			
		}
	}
	
	
	@Override
	public void init(final Application_Base app_context) {
		
		super.init(app_context);
		
		
		//Notifications processor
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				
				//While TRUE Cycle is inside the method checkNotifications
				achievementsManager.checkNotifications(app_context);
			}
		});
	}
}
