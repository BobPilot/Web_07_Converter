package com.example.demo.service;

import com.example.demo.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

@org.springframework.stereotype.Service
public class Service {

    @Value("${key.value}")
    String key;

    public String converter(String from, String to, Double sum){

        String res = "Error. Check your data.";

        Response response = new RestTemplate().exchange(
                "http://data.fixer.io/api/latest?access_key=" + key + "&symbols=" + from + "," + to,
                HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Response.class
        ).getBody();

        if(response.getSuccess() && response.getRates().size() == 2){
            res = "Sum: " + new DecimalFormat("#0.00").format(response.getRates().get(to) / response.getRates().get(from) * sum);
        }

        return res;
    }

}
