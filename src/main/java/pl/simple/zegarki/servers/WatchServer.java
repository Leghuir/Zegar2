package pl.simple.zegarki.servers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.simple.zegarki.basic.Watch;
import pl.simple.zegarki.basic.WatchType;
import pl.simple.zegarki.exception.NoSuchWatchException;
import pl.simple.zegarki.exception.WatchAlreadyExitstsException;
import pl.simple.zegarki.entities.BrokenWatch;
import pl.simple.zegarki.entities.WatchHolder;
import pl.simple.zegarki.entities.WorkingWatch;

@Service
@Qualifier("lista")
public class WatchServer extends Observable implements ServerAble
{
private List<WatchHolder> MyCollectionOfWatches=new ArrayList<>();
private void init()
{
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new BrokenWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new BrokenWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new BrokenWatch("model 1",new Date(), "China", "to jest opis", 777, "tik tak",WatchType.CUCKOOCLOCK)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model swissE400",new Date(),"Swiss","aaa",20000,"cyk",WatchType.SWISSWATCH)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model swissE400",new Date(),"Swiss","aaa",20000,"cyk",WatchType.SWISSWATCH)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model swissE400",new Date(),"Swiss","aaa",20000,"cyk",WatchType.SWISSWATCH)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model swissE400",new Date(),"Swiss","aaa",20000,"cyk",WatchType.SWISSWATCH)));
	MyCollectionOfWatches.add(new WatchHolder(new WorkingWatch("model swissE400",new Date(),"Swiss","aaa",20000,"cyk",WatchType.SWISSWATCH)));
    
}
public WatchServer()
{
	this.init();
}
@Override
public List<WatchHolder> findAll() {
    return this.MyCollectionOfWatches;
}

@Override
public WatchHolder readById(int id) throws NoSuchWatchException {
	return this.MyCollectionOfWatches.stream().filter(p -> Integer.valueOf(p.getId()).equals(id)).findFirst().orElseThrow(NoSuchWatchException::new);

}

@Override
public WatchHolder create(WatchHolder watch) {
	MyCollectionOfWatches.add(watch);
    return watch;
}

@Override
public Watch update(Watch watch) throws NoSuchWatchException {
    for (int i = 0; i < this.MyCollectionOfWatches.size(); i++) {
        if (Objects.equals(this.MyCollectionOfWatches.get(i).getId(), watch.getId())) {
            this.MyCollectionOfWatches.set(i, new WatchHolder(new WorkingWatch(watch)));
            return watch;
        }
    }
    throw new NoSuchWatchException("Nie ma takiego zegarka: " + watch.getId());
}

@Override
public void deleteById(int id) throws NoSuchWatchException {
    for (int i = 0; i < this.MyCollectionOfWatches.size(); i++) {
        if (Objects.equals(this.MyCollectionOfWatches.get(i).getId(), id)) {
            this.MyCollectionOfWatches.remove(i);
        }
    }
    throw new NoSuchWatchException("Nie ma takiego zegarka: " + id);
}

}
