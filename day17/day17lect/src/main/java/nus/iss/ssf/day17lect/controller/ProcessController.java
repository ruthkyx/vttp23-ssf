package nus.iss.ssf.day17lect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nus.iss.ssf.day17lect.service.ProcessService;

@RestController // this controller wont handle any html files
@RequestMapping(path="/process")
public class ProcessController {

    @Autowired
    ProcessService processSvc;

    @PostMapping(path="/searchBook") //  produces="application/xml"
    public String processBookSearch(@RequestBody MultiValueMap<String, String> form) {

        // to pull out the map
        String author = form.getFirst("bookname"); // the key must match the value name in the html
        System.out.println("Author: " + author);

        String result = processSvc.searchBook(author);

        return result;
    }

    @PostMapping(path="/searchCountry") // to process the post request of the form to search for country 
    public String processCountrySearch(@RequestBody MultiValueMap<String, String> form) {
        ResponseEntity<String> results = processSvc.filterCountries(form.getFirst("searchName"));

        return results.getBody();
    }

    @PostMapping(path="searchCountryRegion")
    public String processCountrySearchRegion(@RequestBody MultiValueMap<String, String> form) {
        ResponseEntity<String> results = processSvc.filterRegions(form.getFirst("searchRegion"));
        return results.getBody();
    }
}
