
package com.lumacare;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("powerStatus", "Not reported");
        model.addAttribute("deviceStatus", "Not reported");
        model.addAttribute("batteryLevel", 0);
        return "index";
    }

    @PostMapping("/update-power")
    public String updatePower(
            @RequestParam("powerStatus") String powerStatus,
            Model model) {

        model.addAttribute("powerStatus", powerStatus);
        model.addAttribute("deviceStatus", "Not reported");
        model.addAttribute("batteryLevel", 0);

        return "index";
    }

    @PostMapping("/update-device")
    public String updateDevice(
            @RequestParam("deviceStatus") String deviceStatus,
            @RequestParam("batteryLevel") int batteryLevel,
            Model model) {

        model.addAttribute("powerStatus", "Not reported");
        model.addAttribute("deviceStatus", deviceStatus);
        model.addAttribute("batteryLevel", batteryLevel);

        return "index";
    }
}


