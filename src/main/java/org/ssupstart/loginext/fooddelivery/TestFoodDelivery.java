package org.ssupstart.loginext.fooddelivery;
import org.springframework.stereotype.Component;
import org.ssupstart.loginext.fooddelivery.assignmentstrategiesIMP.DefaultAssignmentStrategy;
import org.ssupstart.loginext.fooddelivery.entity.Order;
import org.ssupstart.loginext.fooddelivery.service.FoodDeliveryService;

@Component
public class TestFoodDelivery {

    public static void main(String[] args) {
        DefaultAssignmentStrategy engine = new DefaultAssignmentStrategy();
        engine.addDrivers(2);
        FoodDeliveryService foodDeliveryController = new FoodDeliveryService(engine);

        System.out.println(foodDeliveryController.deliverFood(new Order(1,1,10)));
        System.out.println(foodDeliveryController.deliverFood(new Order(2,4,20)));
        System.out.println(foodDeliveryController.deliverFood(new Order(3,15,5)));
        System.out.println(foodDeliveryController.deliverFood(new Order(4,22,20)));
        System.out.println(foodDeliveryController.deliverFood(new Order(5,24,10)));
        System.out.println(foodDeliveryController.deliverFood(new Order(6,25,10)));

    }
}
