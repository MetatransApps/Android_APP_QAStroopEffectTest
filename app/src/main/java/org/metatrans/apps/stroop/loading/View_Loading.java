package org.metatrans.apps.stroop.loading;


import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

import org.metatrans.apps.stroop.lib.R;
import org.metatrans.apps.stroop.logic.CfgQuestion_Colours_Image;
import org.metatrans.apps.stroop.logic.GeneratorsFactory;
import org.metatrans.commons.loading.View_Loading_Base;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion_ImageQuestion;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion_TextQuestion;
import org.metatrans.commons.questionnaire.api.IQuestionGenerator;
import org.metatrans.commons.questionnaire.logic.questions.CfgQuestion_Base_TextButtons;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class View_Loading extends View_Loading_Base {
	
	
	private Bitmap[] bitmap_commons;
	private UserSettings_Base settings;
	
	
	public View_Loading(Context context, UserSettings_Base _settings) {
		
		super(context);
		
		settings = _settings;
		
	}
	
	
	@Override
	protected Bitmap getBitmapBackground() {
		return null;
	}
	
	
	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}
	
	
	@Override
	public void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_arc_short_i),
				getImageBitmap(R.drawable.ic_logo),
		};
		
		
		Bitmap[] bitmap_others = new Bitmap[30];
		
		int[] colours_images = new int[] {
				R.drawable.ic_arc_comp_red,
				R.drawable.ic_arc_comp_orange,
				R.drawable.ic_arc_comp_yellow,
				R.drawable.ic_arc_comp_green,
				R.drawable.ic_arc_comp_blue,
				R.drawable.ic_arc_comp_indigo,
				R.drawable.ic_arc_comp_violet,
				/*R.drawable.ic_arc_comp_red_chakra,
				R.drawable.ic_arc_comp_orange_chakra,
				R.drawable.ic_arc_comp_yellow_chakra,
				R.drawable.ic_arc_comp_green_chakra,
				R.drawable.ic_arc_comp_blue_chakra,
				R.drawable.ic_arc_comp_indigo_chakra,
				R.drawable.ic_arc_comp_violet_chakra,*/
			};
		
		IQuestionGenerator generator = GeneratorsFactory.getGenerator_ByType((Application) this.getContext().getApplicationContext(), settings.modeID);
		for (int i=0; i< bitmap_others.length; i++) {
			
			IConfigurationQuestion question = generator.nextQuestion(null);

			if (question instanceof IConfigurationQuestion_TextQuestion) {

				//int imageid = colours_images[i % colours_images.length];
				//bitmap_others[i] = BitmapUtils.fromResource(getContext(), imageid, (int) getSquareSize());

				int colour = ((CfgQuestion_Base_TextButtons) question).getColor_Text();
				String text = (String) question.getQuestion();

				int textWidth = (int) (2 * getSquareSize());
				bitmap_others[i] = BitmapUtils.createFromText(text, textWidth, (int) (textWidth / (double) 3.5),
						Color.rgb(Color.red(colour) / 2, Color.green(colour) / 2, Color.blue(colour) / 2), colour, true);
				createEntry(bitmap_others[i]);

			} else if (question instanceof IConfigurationQuestion_ImageQuestion) {

				bitmap_others[i] = (Bitmap) question.getQuestion();
				createEntry(bitmap_others[i]);

			} else {

				throw new IllegalStateException("question.class=" + question.getClass());
			}
		}
	}
	
	
	protected Bitmap getImageBitmap(int imageResID) {
		return BitmapUtils.fromResource(getContext(), imageResID, (int) getSquareSize());
	}
}
