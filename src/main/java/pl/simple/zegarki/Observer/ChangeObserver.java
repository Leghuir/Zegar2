package pl.simple.zegarki.Observer;

import java.util.Observable;
import java.util.Observer;

import pl.simple.zegarki.basic.Watch;;

public class ChangeObserver implements Observer {

	public ChangeObserver() {
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(((Watch)arg).getModel()+((Watch)arg).makeNoise());

	}

}
