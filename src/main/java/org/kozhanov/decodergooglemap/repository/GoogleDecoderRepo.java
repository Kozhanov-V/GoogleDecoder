package org.kozhanov.decodergooglemap.repository;



import org.json.JSONObject;
import org.kozhanov.decodergooglemap.exception.UnsupportedParamsQuery;
import org.kozhanov.decodergooglemap.utils.CalculatorDistance;
import org.kozhanov.decodergooglemap.utils.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GoogleDecoderRepo implements DecoderRepo{

    @Value("${google.maps.apikey}")
    private String apikey;

    private CalculatorDistance calculatorDistance;

    @Autowired
    public GoogleDecoderRepo(CalculatorDistance calculatorDistance) {
        this.calculatorDistance = calculatorDistance;
    }

    @Override
    public String getPoint(double lat, double lng) {

        final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json";// путь к Geocoding API по HTTP
        final Map<String, String> params = new HashMap<>();
        params.put("language", "ru");
        params.put("sensor", "false");
        params.put("latlng", lat+","+lng);
        params.put("key", apikey);
      final String url = baseUrl + '?' + encodeParams(params);
        final JSONObject response;
        try {
            response = JsonReader.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final JSONObject location = response.getJSONArray("results").getJSONObject(0);
       final String formattedAddress = location.getString("formatted_address");
        return formattedAddress;
    }

    @Override
    public double getDistance(double[] startPos, double[] endPos) {
        if(startPos.length !=2 && endPos.length != 2){
            throw new UnsupportedParamsQuery("Need 2 point in start and end position");
        }
        return calculatorDistance.getDistance(startPos[0],startPos[1],endPos[0], endPos[1]);
    }

    private String encodeParams(final Map<String, String> params) {
        StringBuilder paramsUrl = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!first) {
                paramsUrl.append('&');
            }
            first = false;
            try {
                paramsUrl.append(entry.getKey());
                paramsUrl.append('=');
                paramsUrl.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return paramsUrl.toString();
    }

}
