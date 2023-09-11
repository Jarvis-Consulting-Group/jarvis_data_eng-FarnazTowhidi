package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Quote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class QuoteDao implements CrudRepository<Quote, String> {
    @Override
    public <S extends Quote> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Quote> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Quote> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Quote> findAll() {
        return null;
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Quote entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Quote> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
