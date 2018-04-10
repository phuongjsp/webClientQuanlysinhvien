package hoang.phuong.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

    private final RestTemplate appRestClient;

    @Autowired
    public SomeService(@Qualifier("appRestClient") RestTemplate appRestClient) {
        this.appRestClient = appRestClient;
    }

    public String callRestService() {
        return appRestClient.getForObject("http://localhost:9966/khoa", String.class);
    }
}