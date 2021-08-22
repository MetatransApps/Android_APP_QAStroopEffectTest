package com.easycolours.logic;


import com.apps.mobile.android.commons.questionnaire.api.IConfigurationQuestion_ImageButtons;
import com.apps.mobile.android.commons.questionnaire.api.IConfigurationQuestion_TextQuestion;
import com.apps.mobile.android.commons.questionnaire.logic.questions.CfgQuestion_Base_ImageButtons;


public class CfgQuestion_Colours extends CfgQuestion_Base_ImageButtons implements IConfigurationQuestion_ImageButtons, IConfigurationQuestion_TextQuestion  {
	
	
	private static final long serialVersionUID = -8763624737022681624L;
	
	
	private String question;
	private int colourText;
	
	
	public CfgQuestion_Colours(int _index_correct, Object[] _array, String _question, int _colourText) {
		super(_index_correct, _array);
		question = _question;
		colourText = _colourText;
	}
	
	
	@Override
	public String getQuestion() {
		return question;
	}
	
	
	@Override
	public long getID() {
		throw new IllegalStateException();
	}
	
	
	@Override
	public int getAnswersCount() {
		return getResID_Answers().length;
	}


	@Override
	public int getQuestionColour() {
		return colourText;
	}
}
