package com.ice.datasource.service.impl;

import com.ice.datasource.dao.orders.OrdersMapper;
import com.ice.datasource.dao.users.UsersMapper;
import com.ice.datasource.model.Orders;
import com.ice.datasource.model.Users;
import com.ice.datasource.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl  implements IOrderService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    @Transactional
    public void addOrder(Orders orders, Users users) {
        usersMapper.insertSelective(users);
        int i = 10/0;
        ordersMapper.insertSelective(orders);
    }
}