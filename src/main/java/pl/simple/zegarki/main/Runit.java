package pl.simple.zegarki.main;

import java.util.Date;

import pl.simple.zegarki.servers.WatchServer;
import pl.simple.zegarki.basic.WatchType;
import pl.simple.zegarki.Observer.ChangeObserver;
import pl.simple.zegarki.entities.WorkingWatch;

public class Runit {

	public static void main(String[] args) {
ChangeObserver changeObserver = new ChangeObserver();
WatchServer watchServer = new WatchServer();
watchServer.addObserver(changeObserver);

	}

}
