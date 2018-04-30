package hoang.phuong.client.service.Impl;

import com.google.gson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T> {
    private final String uriServer = "http://localhost:9966/";
    private final Class<T> persistentClass;
    protected RestTemplate restTemplate;
    private GsonBuilder gsonb = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    protected Gson gson = gsonb.create();

    public AbstractService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void UserAPI(String path, HttpMethod httpMethod) {
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<byte[]> response = restTemplate
                .exchange(uriServer + path
                        , httpMethod, requestEntity, byte[].class);
    }

    public String UserAPIReturn(String path, HttpMethod httpMethod) {
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(uriServer + path
                        , httpMethod, requestEntity, String.class);
        return response.getBody();
    }

    protected T getObject(String path) {
        return gson.fromJson(restTemplate.getForObject(uriServer + path, String.class), persistentClass);
    }
    //TOTO add try catch http exeption
    protected List<T> getListEntity(String path) {
        String jsonString = restTemplate.getForObject(uriServer + path, String.class);
        return listTByJsonString(jsonString);
    }

//    protected List<T> getListByProperties(String path, Map<String, String> map) {
//        String jsonString = restTemplate.postForObject(uriServer + path, map, String.class);
//        return listTByJsonString(jsonString);
//
//    }


    protected List<T> listTByJsonString(String jsonString) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, (Type) persistentClass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    protected List<T> getListByListProperties(String path, List<Map<String, Object>> map) {
        String jsonString = restTemplate.postForObject(uriServer + path, map, String.class);
        return listTByJsonString(jsonString);
    }

    protected T saveByMap(String path, Map<String, Object> map) {
        String result = restTemplate.postForObject(uriServer + path, map, String.class);
        return gson.fromJson(result, persistentClass);
    }


    protected T saveAndReturnId(String path, T entity) {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<T> request = new HttpEntity<>(entity, headers);
        return restTemplate.postForObject(uriServer + path, request, persistentClass);
    }

    protected boolean delete(String path) {
        try {
            restTemplate.delete(uriServer + path);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean update(String path, T entity) {
        try {
            restTemplate.put(uriServer + path, entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean updateByMap(String path, Map<String, Object> map) {
        try {
            restTemplate.put(uriServer + path, map);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
