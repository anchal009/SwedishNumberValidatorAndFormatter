package com.linkmobility.numbers.service;

import com.linkmobility.numbers.exception.ApiProcessingException;
import com.linkmobility.numbers.utils.NumbersUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiService {
    public List<String> formatNumbers(List<String> numbers) throws IllegalArgumentException, ApiProcessingException {
        List<String> resultNumbers = new ArrayList<>();
        try {
            for (String s : numbers) {
                String formattedNumber = NumbersUtil.formatSwedishMobileNumber(s);
                resultNumbers.add(formattedNumber);
            }
        } catch (Exception e) {
            throw new ApiProcessingException(e.getMessage());
        }
        return resultNumbers;
    }
}
