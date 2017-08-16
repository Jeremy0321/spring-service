package com.jeremy.pattern.event;

import java.util.EventListener;

public interface MessageListener extends EventListener{

	/**
	 * @param messageObject
	 */
	boolean consumerNotifyMessage(MessageObject messageObject);
}
