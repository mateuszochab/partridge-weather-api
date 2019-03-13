package com.ochabmateusz.partridge.partridgeweatherapi.business;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeatherExtensionForList;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"places"})
public class WeatherServiceBusiness implements WeatherService {


    @Value("${weather.APPID}")
    private String API_ID;
    @Value("${weather.BASEURL}")
    private String baseUrl;
    @Value("${weather.VERSION}")
    private String version;

    @Value("${weather.UNITS}")
    private String units;

    private RestTemplate restTemplate;

    @Autowired
    public WeatherServiceBusiness(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable
    private CityWeather getCityByURL(String url) {

        CityWeather cityWeather = restTemplate.getForObject(url, CityWeather.class);
        return cityWeather;
    }

    private CityWeatherExtensionForList getCitiesByURL(String url) {
//        ResponseEntity<List<CityWeatherExtensionForList>> response=restTemplate.exchange(url, HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<CityWeatherExtensionForList>>() {
//        });
//        List<CityWeatherExtensionForList> listCityWeather=response.getBody();
        CityWeatherExtensionForList cityWeather = restTemplate.getForObject(url, CityWeatherExtensionForList.class);
        return cityWeather;

    }

    @Override
    public CityWeather getCityByName(String cityName) {
        String url = baseUrl + version + "weather?q=" + cityName + "&units=" + units + "&appid=" + API_ID;
        CityWeather cityWeather = getCityByURL(url);
        return cityWeather;
    }

    @Override
    public CityWeather getCityByCoordinates(float lat, float lon) {
        String url = baseUrl + version + "weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_ID;
        CityWeather cityWeather=getCityByURL(url);
        return cityWeather;

    }

    @Override
    public CityWeather getCityByZipCode(String zipCode, String countryCode) {
        String url = baseUrl + version + "weather?zip=" + zipCode + "," + countryCode.toLowerCase() + "&appid=" + API_ID;
        CityWeather cityWeather=getCityByURL(url);
        return cityWeather;
    }

    @Override
    public List<CityWeather> getCitiesInRectArea(float lonLeft, float latBottom, float lonRight, float latTop, int zoom) {
        String url = baseUrl + version + "box/city?bbox=" + lonLeft+"," + latBottom +","+lonRight+","+latTop+","+zoom+ "&appid=" + API_ID;
        CityWeatherExtensionForList cityWeatherExtensionForList=getCitiesByURL(url);

        return cityWeatherExtensionForList.getListOfCityWeather();

    }

}
