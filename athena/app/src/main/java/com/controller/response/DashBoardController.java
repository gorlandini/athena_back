package com.controller.response;



import com.core.domain.notification.app.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class DashBoardController {

    private final NotificationService notificationService;



    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("notifications", notificationService.getNotifications());
        return "dashboard"; // nome do template Thymeleaf
    }
}
