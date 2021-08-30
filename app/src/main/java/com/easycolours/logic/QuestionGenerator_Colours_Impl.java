package com.easycolours.logic;


import android.content.Context;
import android.graphics.Color;

import org.metatransapps.commons.questionnaire.api.IConfigurationQuestion;
import org.metatransapps.commons.questionnaire.api.IQuestionGenerator;
import org.metatransapps.commons.questionnaire.model.GameData;
import org.metatransapps.commons.questionnaire.utils.NumbersUtils;

import com.easycolours.lib.R;


public class QuestionGenerator_Colours_Impl implements IQuestionGenerator {
	
	
	private Context context;
	
	
	private int[] colours_images = new int[] {
			R.drawable.ic_arc_comp_red,
			R.drawable.ic_arc_comp_orange,
			R.drawable.ic_arc_comp_yellow,
			R.drawable.ic_arc_comp_green,
			R.drawable.ic_arc_comp_blue,
			//R.drawable.ic_arc_comp_indigo,
			R.drawable.ic_arc_comp_violet,
		};
	
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
	
	
	public QuestionGenerator_Colours_Impl(Context _context) {
		context = _context;
	}
	
	
	@Override
	public IConfigurationQuestion nextQuestion(GameData gameData) {
		
		
		NumbersUtils.shuffleArray(indexes);
		
		
		IConfigurationQuestion question = new CfgQuestion_Colours(0,
				new Integer[] {colours_images[indexes[0]], colours_images[indexes[1]], colours_images[indexes[2]], colours_images[indexes[3]]},
				context.getString(colours_names[indexes[0]]),
				colours_codes[indexes[1]]);
		

		
		question.shuffle();
		
		return question;
	}
}

