package com.example.demo.model;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Response {

    Boolean success;
    Map<String, Double> rates;

}
