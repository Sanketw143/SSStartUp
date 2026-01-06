package org.ssupstart.API.controller;


//Design and develop a RESTful web service using
//Spring Boot to store and retrieve Car and Customer data.
//The implementation should include:
//Properly designed request and response DTOs
//GET and POST REST endpoints
//Clear separation of controller, service, and repository layers
//Explanation of API design, validations, and best practices followed


import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssupstart.API.entity.Car;
import org.ssupstart.API.exception.CarNotFoundException;
import org.ssupstart.API.service.FetchCarDetailService;

import java.util.List;

@RestController
@RequestMapping("/fetch")
public class SimpleController {

    private FetchCarDetailService fetchCarDetailService;

    public SimpleController(FetchCarDetailService fetchCarDetailService) {
        this.fetchCarDetailService = fetchCarDetailService;
    }

//    @GetMapping("/v1/carDetails")
//    public ResponseEntity<?> getCarDetails(@PathParam("id") int carId) {
//        try {
//            Car c = fetchCarDetailService.fetchCar(carId);
//            return ResponseEntity.ok(c);
//        } catch (CarNotFoundException e) {
//            ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
}
