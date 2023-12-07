package nus.iss.ssf.day17lect.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProcessService {
    
    String url_booksearch = "http://openlibrary.org/search.json?q="; // book search end point

    String url_countries = "https://api.first.org/data/v1/countries"; // countries end point

    RestTemplate template = new RestTemplate(); // template that allows us to make a http call the process url data

    public String searchBook(String author) {

        url_booksearch += author;
        String result = template.getForObject(url_booksearch, String.class);

        return result;
    }

    public ResponseEntity<String> getCountries() {
        ResponseEntity<String> result2 = template.getForEntity(url_countries, String.class);

        return result2;
    }

    public ResponseEntity<String> filterCountries(String name) {
        url_countries += "?q=" + name;
        ResponseEntity<String> result = template.getForEntity(url_countries, String.class);

        return result;
    }

    public ResponseEntity<String> filterRegions(String region) {
        url_countries += "?q=" + region;
        ResponseEntity<String> results = template.getForEntity(url_countries, String.class);
        return results;
    }
}
