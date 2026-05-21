package pushk.order_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String getOrders() {
        return "Order List from Order-Service v4";
    }

    @GetMapping("/host")
    public String getHostName() {
        try {
            return "Request handled by Pod/Host: " + InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unable to determine Host Name: " + e.getMessage();
        }
    }
}