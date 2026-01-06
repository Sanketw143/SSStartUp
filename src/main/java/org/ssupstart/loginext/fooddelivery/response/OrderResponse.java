package org.ssupstart.loginext.fooddelivery.response;

import lombok.Getter;
import lombok.Setter;
import org.ssupstart.loginext.fooddelivery.entity.Driver;
import org.ssupstart.loginext.fooddelivery.entity.Order;

@Getter
@Setter
public class OrderResponse {
    int orderId;
    int driverId;
    String status;

    public OrderResponse() {
    }

    public OrderResponse(int orderId, int driverId, String status) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.status = status;
    }

    public OrderResponse success(Order order, Driver driver) {
        return new OrderResponse(order.getId(), driver.getId(), "Success");
    }

    public OrderResponse failure(Order order, Driver driver) {
        return new OrderResponse(order.getId(), driver.getId(), "No Food :-(");
    }


    @Override
    public String toString() {
        return "C" + orderId + ", D" + driverId + ", status=" + status;
    }
}
