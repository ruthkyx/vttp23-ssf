package nus.iss.ssf.day17lect.controller;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import nus.iss.ssf.day17lect.model.Country;
import nus.iss.ssf.day17lect.service.ProcessService;

@Controller
@RequestMapping(path="/home")
public class HomeController {

    @Autowired
    ProcessService processSvc;
    
    @GetMapping(path="/booksearch") // doesnt have to be the html name but needs to link to the corresponding html file
    public String bookSearchForm() {

        return "booksearch"; // link to the html name 
    }

// requestparam is the query string

    @GetMapping(path="/countries") // this is put in the homecontroller cos this is getmapping 
    public ResponseEntity<String> listCountries() { 
        ResponseEntity<String> result2 = processSvc.getCountries();

        // the redirect: is to redirect it to the other controller to process 
        return result2;
    }

    @GetMapping(path="/countries/jsontest") // use json to read string of data
    public String listCountries2(Model model) { 
        ResponseEntity<String> result3 = processSvc.getCountries();

        String jsonString = result3.getBody().toString(); // cast it back to string

        JsonReader jsonreader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject = jsonreader.readObject();

        JsonObject jsonObjectData = jsonObject.getJsonObject("data");
        System.out.println("jsonObjectData" + jsonObjectData);
        System.out.println("jsonObjectData size" + jsonObjectData.size());

        List <Country> countries = new ArrayList<>();

        Set<Entry<String, JsonValue>> entries = jsonObjectData.entrySet();
        for(Entry<String, JsonValue> entry: entries) {
            System.out.println(entry.getKey() + ">" + entry.getValue().toString());

            countries.add(new Country(entry.getKey(), entry.getValue().asJsonObject().getString("country")));
        }
        model.addAttribute("countries", countries); // this helps to link the list in the controller to the html

        // ReponseEntity changed to String bcos 
        return "countrylist";
    }

    @GetMapping(path="/countrysearch")
    public String searchCountryForm() {
        return "countrysearch";
    }

    @GetMapping(path="/countrysearchregion")
    public String searchRegionForm() {
        return "countrysearchregion";
    }
}
