package org.ssupstart.loginext.fooddelivery.testcasejunit;

import org.junit.jupiter.api.Test;
import org.ssupstart.loginext.fooddelivery.assignmentstrategiesIMP.DefaultAssignmentStrategy;
import org.ssupstart.loginext.fooddelivery.entity.Order;
import org.ssupstart.loginext.fooddelivery.response.OrderResponse;
import org.ssupstart.loginext.fooddelivery.service.FoodDeliveryService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTestCase {
    @Test
    public void validateNoDriverAvailable() {
        Order o = new Order(1,10,10);
        FoodDeliveryService fds = new FoodDeliveryService(new DefaultAssignmentStrategy());
        OrderResponse response = fds.deliverFood(o);
        assertEquals(-1, response.getDriverId());
    }
}
