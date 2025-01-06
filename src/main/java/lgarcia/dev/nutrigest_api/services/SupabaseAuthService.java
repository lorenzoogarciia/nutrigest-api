package lgarcia.dev.nutrigest_api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SupabaseAuthService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service.key}")
    private String supabaseServiceKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String createSupabaseUser(String email, String password) {
        // Crear usuario de auth
        String url = supabaseUrl + "/auth/v1/admin/users";

        // Headers de petición
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + supabaseServiceKey);
        headers.set("apikey", supabaseServiceKey);
        headers.set("Content-Type", "application/json");

        // Body de petición
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        // HTTP Entity
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        // Realizar petición
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error al crear usuario en Supabase" + response.getStatusCode());
        }
    }
}
