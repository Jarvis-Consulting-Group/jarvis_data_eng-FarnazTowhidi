package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.config.MarketDataConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class MarketDataDao implements CrudRepository<IexQuote, String> {
    private static final String IEX_BATCH_PATH= "/stock/market/batch?symbols=%s&types=quote&token=";
    private final String IEX_BATCH_URL;
    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;


    public MarketDataDao (HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig) {
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
    }

    @Override
    public <S extends IexQuote> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    /**
     * Get an IexQuite (Helper method which class findAllByID)
     * @param ticker
     * @throws IllegalArgumentException: If a given ticker is invalid
     * @throws DataRetrievalFailureException: If HTTP request failed
     **/
    @Override
    public Optional<IexQuote> findById(String ticker) {
        Optional<IexQuote> iexQuote;
        List<IexQuote> quotes = findAllById(Collections.singletonList(ticker));
        if (quotes.size() == 0){
            return Optional.empty();
        } else if (quotes.size() == 1){
            iexQuote = Optional.of(quotes.get(0));
        }else {
            throw new DataRetrievalFailureException("Unexpected number of quotes");
        }
        return iexQuote;

    }

    @Override
    public boolean existsById(String ticker) {
        return false;
    }

    @Override
    public Iterable<IexQuote> findAll() {
        return null;
    }

    /**
     * Get quotes from IEX
     * @param tickers: Is a list of tickers
     * @return a list of IexQuot object
     * @throws IllegalArgumentException: If any ticker is invalid or ticker is empty
     * @throws DataRetrievalFailureException: If HTTP request failed
     **/

    @Override
    public List<IexQuote> findAllById(Iterable<String> tickers) {

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
    public void delete(IexQuote entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> entities) {

    }

    @Override
    public void deleteAll() {

    }
    // Deserializes the IEX Quote JSON into an IexQuote domain object.
}


