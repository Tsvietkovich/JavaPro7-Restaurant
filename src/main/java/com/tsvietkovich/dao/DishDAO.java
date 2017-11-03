package com.tsvietkovich.dao;

import com.tsvietkovich.model.Dish;

import java.util.List;

public interface DishDAO {
    void addDish(Dish dish);
    void deleteDish(int[]ids);
    Dish getDishByID(int id);
    void upDateDish(Dish dish,String name,Double price, Double weight, String sale);
    List<Dish> getDishesBetween (Double from, Double to);
    List<Dish> getSaleDishes();
    List<Dish> getAllDishes();
    List<Dish> getDishesUnderWeight(Double weight);

}
