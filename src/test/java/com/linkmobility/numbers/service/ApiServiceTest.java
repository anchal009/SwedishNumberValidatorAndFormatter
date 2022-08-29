package com.linkmobility.numbers.service;

import com.linkmobility.numbers.exception.ApiProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {
    @Mock
    private ApiService apiService;

    @Test
    public void given_wrong_format_swedish_numbers_and_get_formatted_numbers() throws ApiProcessingException {
        List<String> numbers = Arrays.asList("+46709234893",
                "070-3306661",
                "0046709234893",
                "70543007",
                "+46709234893",
                "0046709234893",
                "+4609234892343",
                "073-2594088",
                "0732594088",
                "+46073-2594088");

        List<String> resultList = Arrays.asList("+46709234893",
                "+46703306661",
                "+46709234893",
                "invalid",
                "+46709234893",
                "+46709234893",
                "invalid",
                "+46732594088",
                "+46732594088",
                "+46732594088");

        when(apiService.formatNumbers(numbers)).thenReturn(resultList);

        List<String> numbersResult = apiService.formatNumbers(numbers);
        assertEquals(numbers.size(), numbersResult.size());
        assertEquals(numbersResult.get(3), "invalid");
        assertEquals(numbersResult.get(6), "invalid");
        Set<String> resultSet = new HashSet<>(numbersResult);
        assertEquals(4, resultSet.size());
    }
}
