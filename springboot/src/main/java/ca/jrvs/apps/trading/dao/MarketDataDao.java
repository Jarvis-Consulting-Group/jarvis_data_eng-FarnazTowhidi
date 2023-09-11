package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.config.MarketDataConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Deserializes the IEX Quote JSON into an IexQuote domain object.

public class MarketDataDao implements CrudRepository<IexQuote, String> {

    // Sample: https://jarvis.iex.cloud/v1/stock/msft/quote?token=pk_c44031d3fb58498b9d8d390f6bf787b7
    //private static final String IEX_BATCH_PATH= "/stock/market/batch?symbols=%s&types=quote&token=";
    private static final String IEX_BATCH_PATH= "/stock/%s/quote?token=";
    private final String IEX_BATCH_URL;
    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;


    public MarketDataDao (HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig) {
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
        System.out.println(IEX_BATCH_URL);
    }

    @Override
    public <S extends IexQuote> S save(S entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not implemented");
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
        String uri = String.format(IEX_BATCH_URL, ticker);
        System.out.println("Executing Get request of URL; " + IEX_BATCH_URL);
        try {
            String response = String.valueOf(executeHttpGet(new URI(uri)));
            JSONObject IexQuotesJson = new JSONObject(response);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
//
//        if (quotes.size() == 0){
//            return Optional.empty();
//        } else if (quotes.size() == 1){
//            iexQuote = Optional.of(quotes.get(0));
//        }else {
//            throw new DataRetrievalFailureException("Unexpected number of quotes");
//        }
        return Optional.empty();

    }

    @Override
    public boolean existsById(String ticker) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<IexQuote> findAll() {
        throw new UnsupportedOperationException("Not implemented");
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
        List<IexQuote> iexQuotes = new ArrayList<>();
        return iexQuotes;
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(IexQuote entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Execute a get and return http entity/body as a string
     * @param url: Resource URL
     * @return Http Response or optional empty for 404
     * @throws DataRetrievalFailureException: If HTTP request failed
     */

    public Optional<String> executeHttpGet (URI url) {
        try {
            HttpGet httpGet = new HttpGet(url);

            // Create a custom HTTP client
            CloseableHttpClient httpClient = getHttpClient(httpGet);
            // Execute the request and get the response
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 404){
                return Optional.empty();
            }else if(statusCode != 200){
                throw new DataRetrievalFailureException("Unexpected status code:" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            return Optional.ofNullable(EntityUtils.toString(entity));

        }
        catch ( IOException e) {
            throw new RuntimeException("Exception Get", e);
        }
    }

    /**
     * Borrow a Http client from the httpClientConnectionManager
     * @return a httpClient
     */
    private CloseableHttpClient getHttpClient(HttpGet httpGet){
        return HttpClients.custom()
                .setConnectionManager(httpClientConnectionManager)
                .setConnectionManagerShared(true)
                .build();
    }
}


