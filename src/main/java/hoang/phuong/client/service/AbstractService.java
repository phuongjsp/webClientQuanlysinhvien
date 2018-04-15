package hoang.phuong.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T> {
    private final String uriServer = "http://localhost:9966/";
    private final Class<T> persistentClass;

    private RestTemplate restTemplate = new RestTemplate();
    private GsonBuilder gsonb = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    private Gson gson = gsonb.create();

    public AbstractService() {

//        List<HttpMessageConverter<?>> messageConverter = new ArrayList<HttpMessageConverter<?>>();
//        messageConverter.add(new FormHttpMessageConverter());
//        messageConverter.add(new StringHttpMessageConverter());
//        this.restTemplate.setMessageConverters(messageConverter);
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        ;
    }


    T getObject(String path) {

        return gson.fromJson(restTemplate.getForObject(uriServer + path, String.class), persistentClass);
    }

    List<T> getListEntity(String path) {
        Type listType = new TypeToken<ArrayList<T>>() {
        }.getType();
        return gson.fromJson(restTemplate.getForObject(uriServer + path, String.class), listType);
    }

    List<T> getListByProperties(String path, Map<String, String> map) {
        Type listType = new TypeToken<ArrayList<T>>() {
        }.getType();
        return gson.fromJson(restTemplate.postForObject(uriServer + path, map, String.class), listType);

    }

    List<T> getListByListProperties(String path, List<Map<String, Object>> map) {
        Type listType = new TypeToken<ArrayList<T>>() {
        }.getType();
        return gson.fromJson(restTemplate.postForObject(uriServer + path, map, String.class), listType);

    }

    boolean saveByMap(String path, Map<String, Object> map) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//
//        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
//
//        restTemplate.postForEntity(uriServer+path, request , String.class );
        restTemplate.postForObject(uriServer + path, map, String.class);
        return true;
    }

    boolean save(String path, T entity) {

//set your headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

////set your entity to send
        HttpEntity entit = new HttpEntity(entity, headers);

// send it!
        restTemplate.exchange(uriServer + path, HttpMethod.POST, entit
                , persistentClass);
//        ResponseEntity<?>  res = restTemplate.postForEntity(uriServer + path, gson.fromJson(gson.toJson(entity),persistentClass), persistentClass);
//        System.out.println("res is :"+res);
//        Type listType = new TypeToken<Boolean>() {
//        }.getType();
//        return gson.fromJson(String.valueOf(restTemplate.postForEntity(uriServer+path,entity,persistentClass)), listType);
        return true;
    }

    T saveAndReturnId(String path, T entity) {
        return gson.fromJson(restTemplate.postForObject(uriServer + path, entity, String.class), persistentClass);
    }

    void delete(String path) {
        restTemplate.delete(uriServer + path);
    }

    void update(String path, T entity) {
        restTemplate.put(uriServer + path, entity);
    }

    void updateByMap(String path, Map<String, Object> map) {
        restTemplate.put(uriServer + path, map);
    }
}
