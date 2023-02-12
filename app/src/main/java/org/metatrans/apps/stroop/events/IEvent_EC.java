package org.metatrans.apps.stroop.events;


import org.metatrans.commons.events.Event_Base;
import org.metatrans.commons.events.api.IEvent_Base;


public interface IEvent_EC extends IEvent_Base {


    int MENU_OPERATION_CHANGE_MODE	= 50;

    int WIN_GAME_GET_MEANING 		= 1;
    int WIN_GAME_GET_COLOR   		= 2;

    IEvent_Base EVENT_MENU_OPERATION_CHANGE_MODE = new Event_Base(
            MENU_OPERATION, MENU_OPERATION_CHANGE_MODE,
            STR_MENU_OPERATION, "CHANGE_MODE"
    );

    IEvent_Base EVENT_GAME_WIN_GET_MEANING = new Event_Base(
            WIN_GAME, WIN_GAME_GET_MEANING,
            STR_WIN_GAME, "GET_MEANING"
    );

    IEvent_Base EVENT_GAME_WIN_GET_COLOR = new Event_Base(
            WIN_GAME, WIN_GAME_GET_COLOR,
            STR_WIN_GAME, "GET_COLOR"
    );
}
