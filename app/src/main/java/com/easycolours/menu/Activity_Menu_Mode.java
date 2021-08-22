package com.easycolours.menu;


import java.util.ArrayList;
import java.util.List;

import com.apps.mobile.android.commons.Alerts_Base;
import com.apps.mobile.android.commons.R;
import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.cfg.IConfigurationEntry;
import com.apps.mobile.android.commons.events.api.IEvent_Base;
import com.apps.mobile.android.commons.events.api.IEventsManager;
import com.apps.mobile.android.commons.ui.list.ListViewFactory;
import com.apps.mobile.android.commons.ui.list.RowItem_CIdTD;
import com.apps.mobile.android.commons.ui.utils.BitmapUtils;
import com.easycolours.Activity_Base_EasyColours;
import com.easycolours.cfg.mode.ConfigurationUtils_Mode;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


public class Activity_Menu_Mode extends Activity_Base_EasyColours {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		int currOrderNumber = ConfigurationUtils_Mode.getInstance().getOrderNumber(getUserSettings().modeID);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		ViewGroup frame = ListViewFactory.create_CITD_ByXML(this, inflater, buildRows(currOrderNumber), currOrderNumber, new OnItemClickListener_Menu());
		
		setContentView(frame);
		
		setBackgroundPoster(R.id.commons_listview_frame, 55);
	}
	
	
	public List<RowItem_CIdTD> buildRows(int initialSelection) {
		
		List<RowItem_CIdTD> rowItems = new ArrayList<RowItem_CIdTD>();
		
		IConfigurationEntry[] cfgs = ConfigurationUtils_Mode.getInstance().getAll();

		for (int i = 0; i < cfgs.length; i++) {
			
			IConfigurationEntry cfg = cfgs[i];
			
			int description = cfg.getDescription();
			boolean available = true;
			
			
			Bitmap bitmap = BitmapUtils.fromResource(this, cfg.getIconResID(), getIconSize());
			
			Drawable drawable = BitmapUtils.createDrawable(this, bitmap);
			RowItem_CIdTD item = new RowItem_CIdTD(available, i == initialSelection, drawable, getString(cfg.getName()), getString(description));
			rowItems.add(item);
		}
		
		return rowItems;
	}
	
	
	private class OnItemClickListener_Menu implements
			AdapterView.OnItemClickListener {
		
		
		private OnItemClickListener_Menu() {
		}
		
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
			
			
			int currOrderNumber = ConfigurationUtils_Mode.getInstance().getOrderNumber(getUserSettings().modeID);
			if (position != currOrderNumber) {
				
				AlertDialog.Builder adb = Alerts_Base.createAlertDialog_LoseGame(view.getContext(),
						new DialogInterface.OnClickListener() {
					
							public void onClick(DialogInterface dialog, int which) {
							
								int newCfgID = ConfigurationUtils_Mode.getInstance().getID(position);
								setDifficulty(newCfgID);
								finish();
							}
						});
	
				adb.show();
			} else {
				finish();
			}
			
			//System.out.println("Activity_Menu_Mode: selection=" + position);
		}
		
		
		private void setDifficulty(int computerModeID) {
			
			getUserSettings().modeID = computerModeID;
			
			Application_Base.getInstance().recreateGameDataObject();
			
			IEventsManager eventsManager = Application_Base.getInstance().getEventsManager();
			eventsManager.register(Activity_Menu_Mode.this, eventsManager.create(IEvent_Base.MENU_OPERATION, IEvent_Base.MENU_OPERATION_CHANGE_MODE, computerModeID,
					"MENU_OPERATION", "CHANGE_MODE", "" + computerModeID));
		}
	}
}
