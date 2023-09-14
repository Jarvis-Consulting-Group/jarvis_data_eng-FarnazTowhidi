package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;

import java.util.Optional;

public class QuoteService {
    // calls MarketDataDao methods which queries Quote data from IEX REST API (in JSON format)
    /**
     *
     */

    private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

    public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao) {

        this.quoteDao = quoteDao;
        this.marketDataDao = marketDataDao;

    }

    public IexQuote findIexQuoteByTicker(String ticker){
        Optional<IexQuote> iexQuote = marketDataDao.findById(ticker);

        if(!iexQuote.isPresent()) throw new IllegalArgumentException("ticker is invalid");

        return iexQuote.get();
    }
}
