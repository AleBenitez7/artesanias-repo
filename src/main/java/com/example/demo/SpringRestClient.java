/*package com.example.demo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.Artesania;

import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SpringRestClient {
    private static final String GET_ARTESANIAS_ENDPOINT_URL = "http://localhost:8080/api/artesanias";
    private static final String GET_ARTESANIA_ENDPOINT_URL = "http://localhost:8080/api/artesanias/{id}";
    private static final String CREATE_ATESANIA_ENDPOINT_URL = "http://localhost:8080/api/artesanias";
    private static final String UPDATE_ARTESANIA_ENDPOINT_URL = "http://localhost:8080/api/artesanias/{id}";
    private static final String DELETE_ARTESANIA_ENDPOINT_URL = "http://localhost:8080/api/artesanias/{id}";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();

        // Step1: first create a new employee
        springRestClient.createArtesania();

        // Step 2: get new created employee from step1
        springRestClient.getArtesaniaById();

        // Step3: get all employees
        springRestClient.getArtesanias();

        // Step4: Update employee with id = 1
        springRestClient.updateArtesania();

        // Step5: Delete employee with id = 1
        springRestClient.deleteArtesania();
    }

    private void getArtesanias() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_ARTESANIAS_ENDPOINT_URL, HttpMethod.GET, entity,
            String.class);

        System.out.println(result);
    }

    private void getArtesaniaById() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        Artesania result = restTemplate.getForObject(GET_ARTESANIA_ENDPOINT_URL, Artesania.class, params);

        System.out.println(result);
    }

    private void createArtesania() {

        Artesania newArtesania = new Artesania("v1", "jarron", "ffsds",new BigDecimal(100000000));

        RestTemplate restTemplate = new RestTemplate();
        Artesania result = restTemplate.postForObject(CREATE_ATESANIA_ENDPOINT_URL, newArtesania, Artesania.class);

        System.out.println(result);
    }

    private void updateArtesania() {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "1");
        Artesania updatedArtesania = new Artesania("v2", "jarron", "sdsdlkjs", new BigDecimal(200000));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(UPDATE_ARTESANIA_ENDPOINT_URL, updatedArtesania, params);
    }

    private void deleteArtesania() {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "1");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DELETE_ARTESANIA_ENDPOINT_URL, params);
    }
}
*/
