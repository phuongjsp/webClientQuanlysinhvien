package hoang.phuong.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    private GsonBuilder gsonb = new GsonBuilder();
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
List<T> getListByProperties(String path,Map<String,String> map){
    Type listType = new TypeToken<ArrayList<T>>() {
    }.getType();
    return gson.fromJson(restTemplate.postForObject(uriServer + path,map, String.class), listType);

}
    boolean save(String path, T entity) {

//set your headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

////set your entity to send
        HttpEntity entit = new HttpEntity(entity,headers);

// send it!
      restTemplate.exchange(uriServer+path, HttpMethod.POST, entit
                , persistentClass);
//        ResponseEntity<?>  res = restTemplate.postForEntity(uriServer + path, gson.fromJson(gson.toJson(entity),persistentClass), persistentClass);
//        System.out.println("res is :"+res);
//        Type listType = new TypeToken<Boolean>() {
//        }.getType();
//        return gson.fromJson(String.valueOf(restTemplate.postForEntity(uriServer+path,entity,persistentClass)), listType);
    return true;
    }
     void delete(String path){
           restTemplate.delete(uriServer+path);
    }
    void update(String path,T entity){
        restTemplate.put(uriServer+path,entity);
    }
}
