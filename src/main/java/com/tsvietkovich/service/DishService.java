package com.tsvietkovich.service;

import com.tsvietkovich.model.Dish;

import java.util.List;

public interface DishService {
    void addDish(Dish dish);
    void deleteDish(int[]ids);
    void updateDish (Dish dish,String name,Double price, Double weight, String sale);
    Dish getDishByID(int id);
    List<Dish> getDishesBetween (Double from, Double to);
    List<Dish> getSaleDishes();
    List<Dish> getDishesUnderWeight(Double weight);
    List<Dish> getAllDishes();

}
