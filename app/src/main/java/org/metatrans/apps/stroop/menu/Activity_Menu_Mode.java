package org.metatrans.apps.stroop.menu;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.stroop.Activity_Base_EasyColours;
import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.commons.Alerts_Base;
import org.metatrans.commons.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.IConfigurationEntry;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.events.api.IEvent_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.ui.list.ListViewFactory;
import org.metatrans.commons.ui.list.RowItem_CIdTD;
import org.metatrans.commons.ui.utils.BitmapUtils;

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

		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(((Application_Base) getApplication()).getUserSettings().uiColoursID);

		int color_background = coloursCfg.getColour_Background();

		ViewGroup frame = ListViewFactory.create_CITD_ByXML(this, inflater, buildRows(currOrderNumber), currOrderNumber, color_background, new OnItemClickListener_Menu());

		frame.setBackgroundColor(color_background);

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


	@Override
	protected int getBackgroundImageID() {
		return 0;
	}
}
