package pushk.notification_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${microservices.hostnames.order-service-base-url}")
    private String orderServiceUrl;

    @GetMapping
    public String getNotifications() {
        return "Notification Status from Notification-Service v4";
    }



    @GetMapping("/host")
    public String getOrderHostViaNotification() {
        // [IMPORTANT] give here Kubernetes internal service URL
        // pattern: http://<service-name>:<port>/<endpoint>
//        String orderServiceUrl = "http://order-service-svc:8082/orders/host";

        try {
            String orderResponse = restTemplate.getForObject(orderServiceUrl+"/orders/host", String.class);

            return "Notification-Service received response -> " + orderResponse;
        } catch (Exception e) {
            return "Error calling Order-Service: " + e.getMessage();
        }
    }
}