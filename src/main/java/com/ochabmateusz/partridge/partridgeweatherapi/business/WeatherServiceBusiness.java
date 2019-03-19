package com.ochabmateusz.partridge.partridgeweatherapi.business;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeatherExtensionForList;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
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
    @Cacheable(cacheNames = "places")
    @Override
    public CityWeather getCityByName(String cityName) {
        String url = baseUrl + version + "weather?q=" + cityName + "&units=" + units + "&appid=" + API_ID;
        CityWeather cityWeather = getCityByURL(url);
        log.info("inside getCityByName");
        return cityWeather;
    }

    @Override
    public CityWeather getCityByCoordinates(String... coordinates) {
        String url = baseUrl + version + "weather?lat=" +  coordinates[0]+ "&lon=" + coordinates[1] + "&appid=" + API_ID;
        CityWeather cityWeather=getCityByURL(url);
        return cityWeather;

    }

    @Override
    public CityWeather getCityByZipCode(String zipCode, String countryCode) {
        String url = baseUrl + version + "weather?zip=" + zipCode + "," + countryCode.toLowerCase() + "&appid=" + API_ID;
        CityWeather cityWeather=getCityByURL(url);
        return cityWeather;
    }
    @Cacheable(cacheNames = "placesList")
    @Override
    public List<CityWeather> getCitiesInRectArea(List<String> coordinates) {
      List<Float> listOfFloat=StringListToFloatList(coordinates);

        String url = baseUrl + version + "box/city?bbox=" + listOfFloat.get(0)+"," + listOfFloat.get(1) +","+listOfFloat.get(2)+","+listOfFloat.get(3)+","+listOfFloat.get(4)+ "&appid=" + API_ID;
        CityWeatherExtensionForList cityWeatherExtensionForList=getCitiesByURL(url);
        log.info("inside getCitiesInRectArea");
        return cityWeatherExtensionForList.getListOfCityWeather();

    }

    @Override
    public List<CityWeather> getNumberOfCitiesInCircle(List<String> coordinates) {
        List<Float> listOfFloat=StringListToFloatList(coordinates);
        String url = baseUrl + version + "find?lat=" + listOfFloat.get(0)+"&lon=" + listOfFloat.get(1) +"&cnt="+(int) listOfFloat.get(2).floatValue()+ "&appid=" + API_ID;
        log.info("URLLLL="+url);
        CityWeatherExtensionForList cityWeatherExtensionForList=getCitiesByURL(url);
        log.info("inside getNumberOfCitiesInCircle");


        return cityWeatherExtensionForList.getListOfCityWeather();
    }


    private List<Float> StringListToFloatList(List<String> listOfString){

        List<Float> listOfFloats=new ArrayList<>();
       listOfString.forEach(elem->listOfFloats.add(Float.parseFloat(elem)));

       listOfFloats.forEach(System.out::println);

       return listOfFloats;

    }

}
