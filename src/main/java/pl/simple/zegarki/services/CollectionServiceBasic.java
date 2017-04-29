package pl.simple.zegarki.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import pl.simple.zegarki.exception.NoSuchWatchException;
import pl.simple.zegarki.servers.WatchServer;
import pl.simple.zegarki.entities.WatchHolder;
@Service
@Primary
public class CollectionServiceBasic implements CollectionService {
	 @Autowired
	    @Qualifier("lista")
	    private WatchServer watches;

	@Override
	public List<WatchHolder> findAll() {
		// TODO Auto-generated method stub
		return watches.findAll();
	}


	@Override
	public Optional<WatchHolder> findById(int id) {
        try {
            return Optional.of(watches.readById(id));
        } catch (NoSuchWatchException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<WatchHolder> create(WatchHolder watch) {
		return Optional.of(watches.create(watch));
	}

	@Override
	public Optional<WatchHolder> edit(WatchHolder watch) {
		try {
            return Optional.of(watches.update(watch));
        } catch (NoSuchWatchException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Boolean> deleteById(int id) {
		try {
            watches.deleteById(id);
            return Optional.of(Boolean.TRUE);
        } catch (NoSuchWatchException e) {
            return Optional.empty();
        }
	}

	@Override
	public List<WatchHolder> findLatest3() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<WatchHolder> findAllToSell() {
		// TODO Auto-generated method stub
		return null;
	}

}
