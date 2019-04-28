package capstoneproject.team.betaprototype.controllers;

import capstoneproject.team.betaprototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SiteController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current-usage", method = RequestMethod.GET)
    public String currentUsage(Model model){
        model.addAttribute("users", userService.findCurrentUsers("timeIn"));
        return "current-usage";
    }

    @RequestMapping(value = "/usage-logs")
    public String usageLogs(Model model){
        model.addAttribute("users", userService.findAll());
        return "usage-logs";
    }

    @RequestMapping(value = "/usage-stats")
    public String usageStats(Model model){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("8am", userService.findActiveUsers(800));
        map.put("9am", userService.findActiveUsers(900));
        map.put("10am", userService.findActiveUsers(1000));
        map.put("11am", userService.findActiveUsers(1100));
        map.put("12pm", userService.findActiveUsers(1200));
        model.addAttribute("map", map);
        return "usage-stats";
    }
}
