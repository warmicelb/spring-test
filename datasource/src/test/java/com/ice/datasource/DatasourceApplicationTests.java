package com.ice.datasource;

import com.ice.datasource.model.Orders;
import com.ice.datasource.model.Users;
import com.ice.datasource.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DatasourceApplicationTests {

    @Resource
    private IOrderService iOrderService;

    @Test
    void contextLoads() {

        Users users = new Users();
        users.setUsername("enjoy");
        users.setPasswd("123");
        users.setId(1);


        Orders orders = new Orders();
        orders.setAccount(12);
        orders.setName("娃娃");
        orders.setUserId(1);
        iOrderService.addOrder(orders,users);
    }

}
