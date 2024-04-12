package com.example.demo.controller;


import com.example.demo.service.Wine;
import com.example.demo.service.WineDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DataController {

    @GetMapping("/data")
    public ModelAndView getData() throws IOException {
        InputStream input = new ClassPathResource("data.json").getInputStream();
        List<Wine> wines = new ObjectMapper().readValue(input, new TypeReference<List<Wine>>(){});

        List<WineDto> dtos = wines.stream()
                .map(wine -> {
                    WineDto dto = new WineDto();
                    dto.setWinery(wine.getWinery());
                    dto.setWine(wine.getWine());
                    dto.setImage(wine.getImage());
                    return dto;
                })
                .collect(Collectors.toList());

        ModelAndView mav = new ModelAndView("Get_All");
        mav.addObject("wines", dtos);
        return mav;
    }

    @GetMapping("/data/filter")
    public ModelAndView getFilteredData(@RequestParam(defaultValue = "United States") String location) throws IOException {
    InputStream input = new ClassPathResource("data.json").getInputStream();
    List<Wine> wines = new ObjectMapper().readValue(input, new TypeReference<List<Wine>>(){});

    List<WineDto> dtos = wines.stream()
            .filter(wine -> wine.getLocation().contains(location))
            .map(wine -> {
                WineDto dto = new WineDto();
                dto.setWinery(wine.getWinery());
                dto.setWine(wine.getWine());
                dto.setLocation(wine.getLocation());
                dto.setImage(wine.getImage());
                return dto;
            })
            .collect(Collectors.toList());

    ModelAndView mav = new ModelAndView("Get_Filter");
    mav.addObject("wines", dtos);
    return mav;
}
}