package practice.iss.nus.chukworkshop.service;

import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import practice.iss.nus.chukworkshop.model.Article;

@Service
public class NewService {

    //https://restcountries.com/#endpoints-code
    //https://newsapi.org/docs/endpoints/top-headlines

    @Value("${news.api.key}")
    private String apiKey;

    // GET country: https://restcountries.com/v3.1/alpha?codes={code},{code},{code}
    public Map<String, String> getCountry() {
        Map<String, String> countries = new HashMap<>();

        String url = UriComponentsBuilder
            .fromUriString("https://restcountries.com/v3.1/alpha")
            .queryParam("codes", "ae,ar,at,au,be,bg,br,ca,ch,cn,co,cu,cz,de,eg,fr,gb,gr,hk,hu,id,ie,il,in,it,jp,kr,lt,lv,ma,mx,my,ng,nl,no,nz,ph,pl,pt,ro,rs,ru,sa,se,sg,si,sk,th,tr,tw,ua,us,ve,za")
            .build()
            .toString();

            // configure the get invocation: v3.1/alpha?codes=sg,my,jp
        RequestEntity<Void> req = RequestEntity
            .get(url)
            .accept(MediaType.APPLICATION_JSON)
            .build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        // creating new instance of JsonReader to read a JSON string fromthe responsebody of a HTTP request. basically js reading json data
        JsonReader reader = Json.createReader(new StringReader(resp.getBody()));
        
        // JsonValue parses the Json string to JsonObject; iterating over each item in the Json array & processing them as a json object
        // readArray is reading the jsonArray from the JsonString
        for (JsonValue val : reader.readArray()) {
            // convert he current JsonValue to a JsonObject (assumes that each item in the JsonArray is a Json object)
            JsonObject obj = val.asJsonObject();
            // in the json array, the country code is mapped to the key "cca2". so get key cca = country code
            String countryCode = obj.getString("cca2");
            // "common" is the key to the value country
            String country =  obj.getJsonObject("name").getString("common");
            // putting into our hashmap 
            countries.put(countryCode, country);
        }

        return countries;
    }

    public List<String> getCategories() {
        String[] categories = {"Business","Entertainment","General","Health","Science","Sports","Technology"};
        return Arrays.asList(categories);
    }

    // GET news: https://newsapi.org/v2/top-headlines?country=de&category=business&apiKey=9d346bac44dc406da10bcd8e967aa74d
    public List<Article> getNews(String category, String country) {
        List<Article> news = new LinkedList<>();

        String url = UriComponentsBuilder
            .fromUriString("https://newsapi.org/v2/top-headlines")
            .queryParam("country", country)
            .queryParam("category", category)
            .queryParam("apikey", apiKey)
            .build()
            .toString();

        RequestEntity<Void> req = RequestEntity
            .get(url)
            .accept(MediaType.APPLICATION_JSON)
            .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        JsonReader reader = Json.createReader(new StringReader(resp.getBody()));
        // key name is "articles" in the rest api json object
        JsonArray array = reader.readObject().getJsonArray("articles");

        for(JsonValue val : array) {
            JsonObject obj = val.asJsonObject();
            // the dafault value is gor if there's no title or value for this key, then it'll still return articles w/o those fields
            String title = obj.getString("title", "");
            String urlToImage = obj.getString("urlToImage", "");
            String author = obj.getString("author", "");
            String description = obj.getString("description", "");
            String publishedAt = obj.getString("publishedAt", "");
            String articleUrl = obj.getString("url", "");
            news.add(new Article(title, urlToImage, author, description, publishedAt, articleUrl));
        }

        return news;
    }
}
