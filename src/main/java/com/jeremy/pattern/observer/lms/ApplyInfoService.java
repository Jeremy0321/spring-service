package com.jeremy.pattern.observer.lms;

import java.util.List;

public class ApplyInfoService implements ApplyStatusUpdateSubject {

	List<ApplyStatusUpdateObserver> observers;

	// applyInfoDao

	public ApplyInfoService(List<ApplyStatusUpdateObserver> observers) {
		super();
		this.observers = observers;
	}

	void updateApplyStatus(Integer applyId, Integer applyStatus) {
		// TODO update applyInfoDao.update(applyId, applyStatus)
		notifyObservers(applyId);
	}


	public void registerObserver(ApplyStatusUpdateObserver o) {
		observers.add(o);
	}

	public void removeObserver(ApplyStatusUpdateObserver o) {
		// TODO Auto-generated method stub

	}

	public void notifyObservers(Integer applyId) {
		for(ApplyStatusUpdateObserver o:observers){
			o.update(applyId);
		}
	}

}
