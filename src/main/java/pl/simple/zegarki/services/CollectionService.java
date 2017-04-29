package pl.simple.zegarki.services;

import java.util.List;
import java.util.Optional;

import pl.simple.zegarki.entities.WatchHolder;

public interface CollectionService {
    List<WatchHolder> findAll();

    List<WatchHolder> findAllToSell();

    Optional<WatchHolder> findById(int id);

    Optional<WatchHolder> create(WatchHolder moneta);

    Optional<WatchHolder> edit(WatchHolder moneta);

    Optional<Boolean> deleteById(int id);

    List<WatchHolder> findLatest3();
}
