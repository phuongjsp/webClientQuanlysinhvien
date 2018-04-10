package hoang.phuong.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService< T> {
    private final String uriServer = "http://localhost:9966/";
    private final Class<T> persistentClass;
    public AbstractService() {
        this.persistentClass =  (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];;
    }
    protected GsonBuilder gsonb = new GsonBuilder();
   protected Gson gson = gsonb.create();
    protected RestTemplate restTemplate = new RestTemplate();
//@Autowired
//GsonBuilder gsonBuilder;
//    @Autowired
//    Gson gson;
//    @Autowired
//    RestTemplate restTemplate;
    protected String EventAsString(String path){
        List<HttpMessageConverter<?>> messageConverter = new ArrayList<HttpMessageConverter<?>>();
        messageConverter.add(new FormHttpMessageConverter());
        messageConverter.add(new StringHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverter);
        return restTemplate.getForObject(path, String.class);
//       restTemplate.setRequestFactory(new CommonsClientHttpRequestFactory());
    }
T getObject(String path){
path = uriServer+path;
       return gson.fromJson(EventAsString(path),persistentClass);
}
List<T> getListEntity(String path){
    path = uriServer+path;
    Type listType = new TypeToken<ArrayList<T>>(){}.getType();
return new Gson().fromJson(EventAsString(path), listType);
}
}
