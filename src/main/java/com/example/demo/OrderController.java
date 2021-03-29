package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/orders")
class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId) {
        // id로 조회
        Order orders = service.getOrder(orderId);

        // api 사용자가 할 수 있는 일을 추가한다.
        Link link = new Link("http://localhost:8080/orders");
        // withSelfRel => 현재 요청 받은 URI
        Link self = linkTo(OrderController.class).slash(orders.getId()).withSelfRel();
        // withRel => 클라이언트가 바라볼 이름 modify(수정)
        Link modify = linkTo(OrderController.class).slash(orders.getId()).withRel("modify").withType("UPDATE");
        // withType => DELETE 메소드로 호출할 수 있음을 알림
        Link cancel = linkTo(OrderController.class).slash(orders.getId()).withRel("cancel").withType("DELETE");

        // 링크로 삽입
        orders.add(link);
        orders.add(self);
        orders.add(modify);
        orders.add(cancel);

        // Order{identity='P0002', goods='지우개', quantity=1, orderer='김민수'}
        System.out.println(orders);

        return new ResponseEntity<Order>(orders, HttpStatus.OK);
    }
}