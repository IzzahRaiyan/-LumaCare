

package com.lumacare;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SOSController {

    @PostMapping("/send-sos")
    public Map<String, String> sendSOS(
            @RequestBody Map<String, String> contact) {

        String name = contact.get("name");
        String phone = contact.get("phone");

        Map<String, String> response = new HashMap<>();

        if (name == null || name.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()) {

            response.put("status", "error");
            response.put("message",
                    "Please save the caregiver name and phone number first.");

            return response;
        }

        response.put("status", "success");
        response.put("caregiver", name);
        response.put("phone", phone);
        response.put("time", LocalDateTime.now().toString());
        response.put("message",
                "Demo SOS request processed by the LumaCare Java backend. "
                + "No caregiver or emergency service was contacted.");

        return response;
    }
}


