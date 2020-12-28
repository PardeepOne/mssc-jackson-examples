package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json =  "{\"id\":\"ddce54e5-d92c-4766-be05-8ebd50e7b86b\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":null,\"price\":15.25,\"createdDate\":\"2020-12-28T22:04:58.4093212+01:00\",\"lastUpdatedDate\":null}";
        BeerDto dto = objectMapper.readValue(json,BeerDto.class);

        System.out.println(dto);
    }
}