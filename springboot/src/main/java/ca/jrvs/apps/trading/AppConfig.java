package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.model.domain.config.MarketDataConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.net.URI;
import java.net.URISyntaxException;

public class AppConfig {
    public static void main(String[] args) throws URISyntaxException {
        MarketDataConfig marketDataConfig = new MarketDataConfig();
        marketDataConfig.setHost("https://jarvis.iex.cloud/v1");
        marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));
        System.out.println("IEX Token:" + marketDataConfig.getToken());
        HttpClientConnectionManager httpClientConnectionManager = httpClientConnectionManager();

        MarketDataDao marketDataDao = new MarketDataDao(httpClientConnectionManager,marketDataConfig);
        marketDataDao.findById("aapl");
    }

    public static HttpClientConnectionManager httpClientConnectionManager(){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        return cm;
    }
}
