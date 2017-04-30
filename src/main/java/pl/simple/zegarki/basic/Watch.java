package pl.simple.zegarki.basic;

import java.util.Date;
import java.util.List;

public interface Watch {
	public int getId();
	public void setId(int id_number);

	public String getDescribe();

	public void setDescribe(String describe);

	public int getValue();

	public void setValue(int value);

	public void setVoice(String voice);

	public String getModel();

	public Date getMadeDate();
	public WatchType getType();

	public String getCountry_name();

	public String makeNoise();
	
	public void setCountry_name(String country);
}
