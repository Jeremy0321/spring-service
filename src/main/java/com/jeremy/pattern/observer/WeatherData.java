package com.jeremy.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	
	List<Observer> observers;
	
	float temp;
	float humidity;
	float pressure;

	public WeatherData() {
		super();
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >=0){
			observers.remove(o);
		}
	}

	public void notifyObservers() {
		for(Observer o:observers){
			o.update(temp, humidity, pressure);
		}
	}
	
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMesurements(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		this.measurementsChanged();
	}

}
