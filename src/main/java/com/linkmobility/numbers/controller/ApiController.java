package com.linkmobility.numbers.controller;

import com.linkmobility.numbers.dto.Numbers;
import com.linkmobility.numbers.exception.ApiProcessingException;
import com.linkmobility.numbers.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/numbers")
@Slf4j
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ResponseEntity<Numbers> getFormattedJSON(@RequestBody Numbers numbers) throws ApiProcessingException {
        Numbers numbersResult = new Numbers();
        if (numbers != null && null != numbers.getNumbers() && numbers.getNumbers().size() > 0) {
            List<String> result = apiService.formatNumbers(numbers.getNumbers());
            numbersResult.setNumbers(result);
        }
        return ResponseEntity.ok(numbersResult);
    }
}
