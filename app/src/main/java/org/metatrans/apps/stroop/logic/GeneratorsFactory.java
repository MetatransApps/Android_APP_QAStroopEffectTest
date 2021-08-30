package org.metatrans.apps.stroop.logic;


import android.app.Application;

import org.metatrans.apps.stroop.cfg.mode.ConfigurationUtils_Mode;
import org.metatrans.commons.questionnaire.api.IQuestionGenerator;


public class GeneratorsFactory {
	
	
	private static IQuestionGenerator gen_colours;
	private static IQuestionGenerator gen_words;
	
	
	public static IQuestionGenerator getGenerator_ByType(Application context, int modeID) {
		if (gen_colours == null) {
			gen_colours = new QuestionGenerator_Colours_Impl(context);
		}
		if (gen_words == null) {
			gen_words = new QuestionGenerator_Words_Impl(context);
		}
		
		if (modeID == ConfigurationUtils_Mode.MODE_GETMEANING) {
			return gen_colours;
		} else {
			return gen_words;
		}
	}
}
