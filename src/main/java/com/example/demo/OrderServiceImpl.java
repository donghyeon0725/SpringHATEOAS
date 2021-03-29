package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    // 저장소 => DB 대신
    private static List<Order> DB = new ArrayList<>();

    public OrderServiceImpl() {
        DB.add(new Order("P0001", "김민수", "마우스", 2));
        DB.add(new Order("P0002", "김민수",  "지우개", 1));
        DB.add(new Order("P0003", "김인직",  "연필", 7));
        DB.add(new Order("P0004", "이광수",  "포스트잇", 10));
    }

    @Override
    public Order getOrder(String orderId) {
        return DB.stream().filter(e->orderId.equals(e.getIdentity())).findFirst().get();
    }

}
