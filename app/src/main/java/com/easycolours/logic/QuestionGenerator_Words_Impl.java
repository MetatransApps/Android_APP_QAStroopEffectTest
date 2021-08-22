package com.easycolours.logic;


import android.content.Context;
import android.graphics.Color;

import com.apps.mobile.android.commons.questionnaire.api.IConfigurationQuestion;
import com.apps.mobile.android.commons.questionnaire.api.IQuestionGenerator;
import com.apps.mobile.android.commons.questionnaire.model.GameData;
import com.apps.mobile.android.commons.questionnaire.utils.NumbersUtils;
import com.easycolours.lib.R;


public class QuestionGenerator_Words_Impl implements IQuestionGenerator {
	
	
	private Context context;
	
	
	private int[] colours_codes = new int[] {
			Color.rgb(255, 0, 0),
			Color.rgb(255, 127, 0),
			Color.rgb(255, 255, 0),
			Color.rgb(0, 255, 0),
			Color.rgb(0, 0, 255),
			//Color.rgb(122, 0, 229),
			Color.rgb(211, 0, 201),
		};
	
	private int[] colours_names = new int[] {
			R.string.ec_colour_red,
			R.string.ec_colour_orange,
			R.string.ec_colour_yellow,
			R.string.ec_colour_green,
			R.string.ec_colour_blue,
			//R.string.ec_colour_indigo,
			R.string.ec_colour_violet,
		};
	
	
	private int[] indexes = new int[] {0, 1, 2, 3, 4, 5/*, 6*/};
	
	
	public QuestionGenerator_Words_Impl(Context _context) {
		context = _context;
	}
	
	
	@Override
	public IConfigurationQuestion nextQuestion(GameData gameData) {
		
		
		NumbersUtils.shuffleArray(indexes);
		
		
		IConfigurationQuestion question = new CfgQuestion_Words(1,
				new String[] {
					fill(context.getString(colours_names[indexes[0]])),
					fill(context.getString(colours_names[indexes[1]])),
					fill(context.getString(colours_names[indexes[2]])),
					fill(context.getString(colours_names[indexes[3]]))
				},
				context.getString(colours_names[indexes[0]]),
				colours_codes[indexes[1]]);
		

		
		question.shuffle();
		
		return question;
	}


	private String fill(String string) {
		if (string.length() == 3) {
			return "   " + string + "   ";
		} else if (string.length() == 4) {
			return "  " + string + "  ";
		} else {
			return " " + string + " ";
		}
	}
}
