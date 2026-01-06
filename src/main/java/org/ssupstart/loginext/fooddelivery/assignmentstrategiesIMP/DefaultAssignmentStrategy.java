package org.ssupstart.loginext.fooddelivery.assignmentstrategiesIMP;

import org.springframework.stereotype.Component;
import org.ssupstart.loginext.fooddelivery.entity.Driver;
import org.ssupstart.loginext.fooddelivery.entity.Order;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;

@Component
public class DefaultAssignmentStrategy implements Assignable {

    // We can put then comparing and another field if needed
    Comparator<Driver> priorityComparator = Comparator.comparingInt(Driver::getFreeTime);
    PriorityQueue<Driver> totalAvailableDrivers = new PriorityQueue<>(priorityComparator);

    public void addDrivers(int noOfDrivers) {
        for(int i=1; i<=noOfDrivers; i++) {
            totalAvailableDrivers.offer(new Driver(i));
        }
    }

    //Main logic
    @Override
    public Optional<Driver> assign(Order order) {
        Driver driver = totalAvailableDrivers.peek();
        if(Objects.nonNull(driver)) {
            if(driver.isAvailable(order.getOrderTime())) {
                totalAvailableDrivers.poll();
                driver.assign(order);
                totalAvailableDrivers.offer(driver);
                return Optional.of(driver);
            }
        }
        return Optional.empty();
    }
}
