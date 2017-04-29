package pl.simple.zegarki.servers;

import java.util.List;

import pl.simple.zegarki.basic.Watch;
import pl.simple.zegarki.exception.NoSuchWatchException;
import pl.simple.zegarki.exception.WatchAlreadyExitstsException;
import pl.simple.zegarki.entities.WatchHolder;


public interface ServerAble {
    WatchHolder create(WatchHolder watch) throws WatchAlreadyExitstsException;
    WatchHolder readById(int id) throws NoSuchWatchException;
    WatchHolder update(WatchHolder watch) throws NoSuchWatchException;
    void deleteById(int id) throws NoSuchWatchException;
    List<WatchHolder> findAll();
}
