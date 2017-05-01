package pl.simple.zegarki.entities;

import java.util.Date;
import java.util.List;

import pl.simple.zegarki.exception.NoSuchWatchException;
import pl.simple.zegarki.basic.Watch;
import pl.simple.zegarki.basic.WatchType;

public class BrokenWatch implements Watch{
	protected int id;
	protected String Model;
	protected Date madeDate;
	protected String country_name;
	protected String describe;
	protected int value;
	protected String voice;
	private WatchType type;
	public BrokenWatch(Watch watch)
	{
		Model = watch.getModel();
		this.madeDate = watch.getMadeDate();
		this.country_name = watch.getCountry_name();
		this.describe = watch.getDescribe();
		this.value = watch.getValue();
		this.voice = watch.makeNoise();
		this.type= watch.getType();
	}
	public BrokenWatch(String model, Date madeDate, String country_name, String describe, int value, String voice,WatchType type) {
		Model = model;
		this.madeDate = madeDate;
		this.country_name = country_name;
		this.describe = describe;
		this.value = value;
		this.voice = voice;
		this.type=type;
	}
	public void setCountry_name(String country) {
		country_name=country;
	}

	public BrokenWatch() {
		// TODO Auto-generated constructor stub
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}



	public void setVoice(String voice) {
		this.voice = voice;
	}


	public String getModel() {
		return Model;
	}


	public Date getMadeDate() {
		return madeDate;
	}


	public String getCountry_name() {
		return country_name;
	}


	public String makeNoise()
	{
		return voice;
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}


	@Override
	public void setId(int id_number) {
		// TODO Auto-generated method stub
		this.id=id_number;
	}
	@Override
	public WatchType getType() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public WorkingWatch reapir() {
		// TODO Auto-generated method stub
		return new WorkingWatch(this);
	}
}
