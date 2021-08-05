package edu.miu.cs.cs544.client1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.miu.cs.cs544.client1.model.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryRegionService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${countryRegionService.service-name}")
    private String serverName;

    @Value("${countryRegionService.username}")
    private String username;

    @Value("${countryRegionService.password}")
    private String password;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public CountryRegion findById(String countryCode) {
        String url = getBaseServiceUrl() + "/countries/" + countryCode;
        return restTemplate
                .getForObject(url,
                        CountryRegion.class);
    }

    public CountryRegion findByIdFallback(String countryCode) {
        System.out.println("Inside findByIdFallback()");
        return new CountryRegion();
    }
    private List<CountryRegion> countryListCache = new ArrayList<>();
    @HystrixCommand(fallbackMethod = "defaultGetAllCountries")
    public List<CountryRegion> findAll() {
        String url = getBaseServiceUrl() + "/countries";
        countryListCache = Arrays.asList(restTemplate.exchange(url, HttpMethod.GET,
                createHttpEntity(), CountryRegion[].class).getBody());
        return countryListCache;
    }

    public List<CountryRegion> defaultGetAllCountries() {
        return countryListCache;
    }

    private HttpEntity<Object> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth(username, password);

        return new HttpEntity<>(headers);
    }

    private String getBaseServiceUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        serviceInstances.forEach(System.out::println);
        return serviceInstances.get(0).getUri().toString();
    }
}
