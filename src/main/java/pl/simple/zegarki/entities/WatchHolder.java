package pl.simple.zegarki.entities;

import java.util.Date;
import java.util.Observable;

import pl.simple.zegarki.basic.Watch;
import pl.simple.zegarki.basic.WatchType;

public class WatchHolder extends Observable implements Watch{
	private Watch currentState;
	private static int count=1;

	public WatchHolder(Watch currentState) {
		super();
		this.currentState = currentState;
		this.setId(WatchHolder.count);
		WatchHolder.count++;
	}
	public void setCountry_name(String country) {
		currentState.setCountry_name(country);
	}
	@Override
	public WatchType getType() {
		// TODO Auto-generated method stub
		return currentState.getType();
	}
	public String getDescribe() {
		return currentState.getDescribe();
	}


	public void setDescribe(String describe) {
		currentState.setDescribe(describe);
	}


	public int getValue() {
		return currentState.getValue();
	}


	public void setValue(int value) {
		currentState.setValue(value);
	}



	public void setVoice(String voice) {
		currentState.setVoice(voice);
	}


	public String getModel() {
		return currentState.getModel();
	}


	public Date getMadeDate() {
		return currentState.getMadeDate();
	}


	public String getCountry_name() {
		return currentState.getCountry_name();
	}


	public String makeNoise()
	{
		return currentState.makeNoise();
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return currentState.getId();
	}


	@Override
	public void setId(int id_number) {
		// TODO Auto-generated method stub
		currentState.setId(id_number);
	}

}
