package org.garlikoff.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UniversalTransport {
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> payload = new HashMap<>();
    private String type;
}
