package com.example.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HttpController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        response.put("method", "GET");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/data")
    public ResponseEntity<Map<String, Object>> postData(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("received", data);
        response.put("method", "POST");
        response.put("status", "Data received successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<Map<String, Object>> putData(@PathVariable String id, @RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("updated", data);
        response.put("method", "PUT");
        response.put("status", "Data updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<Map<String, String>> deleteData(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        response.put("id", id);
        response.put("method", "DELETE");
        response.put("status", "Data deleted successfully");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/data/{id}")
    public ResponseEntity<Map<String, Object>> patchData(@PathVariable String id, @RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("patched", data);
        response.put("method", "PATCH");
        response.put("status", "Data patched successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/params")
    public ResponseEntity<Map<String, Object>> getParams(@RequestParam Map<String, String> params) {
        Map<String, Object> response = new HashMap<>();
        response.put("parameters", params);
        response.put("method", "GET");
        response.put("status", "Parameters received");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/headers")
    public ResponseEntity<Map<String, Object>> getHeaders(@RequestHeader Map<String, String> headers) {
        Map<String, Object> response = new HashMap<>();
        response.put("headers", headers);
        response.put("method", "GET");
        response.put("status", "Headers received");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/form")
    public ResponseEntity<Map<String, String>> handleForm(@RequestParam Map<String, String> formData) {
        Map<String, String> response = new HashMap<>();
        response.put("formData", formData.toString());
        response.put("method", "POST");
        response.put("status", "Form data received");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> checkStatus() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Server is running");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/echo", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<Map<String, Object>> echo(@RequestBody(required = false) Map<String, Object> body,
                                                   @RequestParam Map<String, String> params,
                                                   @RequestHeader Map<String, String> headers,
                                                   RequestMethod method) {
        Map<String, Object> response = new HashMap<>();
        response.put("method", method.name());
        response.put("parameters", params);
        response.put("headers", headers);
        if (body != null) {
            response.put("body", body);
        }
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }
}