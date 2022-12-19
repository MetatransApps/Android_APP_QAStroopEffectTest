package org.metatrans.apps.stroop.logic;


import android.graphics.Bitmap;
import android.graphics.Matrix;

import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion_ImageQuestion;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion_TextButtons;
import org.metatrans.commons.questionnaire.logic.questions.CfgQuestion_Base_TextButtons;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class CfgQuestion_Colours_Image extends CfgQuestion_Base_TextButtons

		implements IConfigurationQuestion_TextButtons, IConfigurationQuestion_ImageQuestion {


	private static final long serialVersionUID = -8763624737022681624L;


	private String bitmap_text_str;

	private int color_background;

	private transient Bitmap bitmap;


	public CfgQuestion_Colours_Image(int _index_correct, Integer[] _array, String _bitmap_text_str, int _color_background) {

		super(_index_correct, _array, _bitmap_text_str, _color_background, -1);

		bitmap_text_str = _bitmap_text_str;

		color_background = _color_background;
	}


	@Override
	public int getColor_Area() {

		return color_background;
	}


	@Override
	public int getResID_Question() {

		return -1;
	}


	/*@Override
	public Object[] getAnswers() {

		String[] buttons_text = new String[4];

		for (int i=0; i<buttons_text.length; i++) {

			buttons_text[i] = " ";
		}

		return buttons_text;
	}*/


	@Override
	public Bitmap getQuestion() {


		if (bitmap == null) {

			Bitmap bitmap_card = BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_wisconsin_card_9_white_v5);

			Matrix matrix = new Matrix();
			matrix.postRotate(90);
			bitmap_card = Bitmap.createBitmap(bitmap_card, 0, 0, bitmap_card.getWidth(), bitmap_card.getHeight(), matrix, true);

			Bitmap bitmap_text = BitmapUtils.textAsBitmap(

					bitmap_text_str,
					bitmap_card.getWidth() / 5.791f,
					color_background
			);

			bitmap_text = BitmapUtils.createScaledBitmap(bitmap_text, bitmap_text.getWidth(), bitmap_text.getHeight());

			//bitmap_text = BitmapUtils.createScaledBitmap(bitmap_text, bitmap_card.getWidth(), bitmap_card.getHeight());


			Bitmap bitmap_question = BitmapUtils.overlay_center(bitmap_card, bitmap_text);

			bitmap = bitmap_question;
		}


		return bitmap;
	}


	@Override
	public long getID() {

		throw new IllegalStateException();
	}
}
