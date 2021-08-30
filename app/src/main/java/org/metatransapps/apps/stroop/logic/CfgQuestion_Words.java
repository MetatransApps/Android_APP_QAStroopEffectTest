package org.metatransapps.apps.stroop.logic;


import org.metatransapps.commons.questionnaire.api.IConfigurationQuestion_TextButtons;
import org.metatransapps.commons.questionnaire.api.IConfigurationQuestion_TextQuestion;
import org.metatransapps.commons.questionnaire.logic.questions.CfgQuestion_Base_TextButtons;


public class CfgQuestion_Words extends CfgQuestion_Base_TextButtons implements IConfigurationQuestion_TextButtons, IConfigurationQuestion_TextQuestion  {
	
	
	private static final long serialVersionUID = -8763624737022681624L;
	
	
	private String question;
	private int colourText;
	
	
	public CfgQuestion_Words(int _index_correct, Object[] _array, String _question, int _colourText) {
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
		return getAnswers().length;
	}


	@Override
	public int getQuestionColour() {
		return colourText;
	}
}
