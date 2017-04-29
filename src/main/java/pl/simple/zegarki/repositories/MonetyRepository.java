package pl.simple.zegarki.repositories;

import java.util.List;

import pl.simple.zegarki.entities.Moneta;
import pl.simple.zegarki.exception.MonetaAlreadyExistsException;
import pl.simple.zegarki.exception.NoSuchMonetaException;


public interface MonetyRepository {
    Moneta create(Moneta moneta) throws MonetaAlreadyExistsException;
    Moneta readById(Long id) throws NoSuchMonetaException;
    Moneta update(Moneta moneta) throws NoSuchMonetaException;
    void deleteById(Long id) throws NoSuchMonetaException;
    List<Moneta> findAll();
}