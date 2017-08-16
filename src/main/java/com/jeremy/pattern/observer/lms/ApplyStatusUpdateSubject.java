package com.jeremy.pattern.observer.lms;

public interface ApplyStatusUpdateSubject {

	void registerObserver(ApplyStatusUpdateObserver o);
	
	void removeObserver(ApplyStatusUpdateObserver o);
	
	void notifyObservers(Integer applyId);
}
