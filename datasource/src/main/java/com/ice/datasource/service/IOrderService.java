package com.ice.datasource.service;

import com.ice.datasource.model.Orders;
import com.ice.datasource.model.Users;

public interface IOrderService {
     void addOrder(Orders orders, Users users);
}