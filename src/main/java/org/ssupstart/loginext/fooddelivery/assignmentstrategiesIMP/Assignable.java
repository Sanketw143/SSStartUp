package org.ssupstart.loginext.fooddelivery.assignmentstrategiesIMP;

import org.ssupstart.loginext.fooddelivery.entity.Driver;
import org.ssupstart.loginext.fooddelivery.entity.Order;

import java.util.Optional;

public interface Assignable {
    Optional<Driver> assign(Order order);
}
