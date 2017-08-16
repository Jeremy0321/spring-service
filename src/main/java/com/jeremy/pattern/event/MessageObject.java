package com.jeremy.pattern.event;

import java.util.EventObject;

/**
 * 消息体
 * @author jeremy
 *
 */
public class MessageObject extends EventObject{

	String notifyType;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MessageObject(Object source, String notifyType) {
		super(source);
		this.notifyType = notifyType;
	}

	
}
