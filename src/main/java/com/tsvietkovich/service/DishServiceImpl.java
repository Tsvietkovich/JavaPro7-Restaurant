package com.tsvietkovich.service;

import com.tsvietkovich.dao.DishDAO;
import com.tsvietkovich.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDAO dishDAO;

    @Transactional(readOnly=true)
    public List<Dish> getDishesUnderWeight(Double weight) {
        return dishDAO.getDishesUnderWeight(weight);
    }


    @Transactional(readOnly = true)
    public List<Dish> getAllDishes() {
        return dishDAO.getAllDishes();
    }


    @Transactional
    public void addDish(Dish dish) {
        dishDAO.addDish(dish);
    }

    @Transactional
    public void deleteDish(int[] ids) {
        dishDAO.deleteDish(ids);
    }

    @Transactional
    public void updateDish(Dish dish,String name,Double price, Double weight, String sale) {
        dishDAO.upDateDish(dish, name, price,  weight,  sale);
    }

    @Transactional
    public Dish getDishByID(int id) {
        return dishDAO.getDishByID(id);
    }

    @Transactional(readOnly=true)
    public List<Dish> getDishesBetween(Double from, Double to) {
        return dishDAO.getDishesBetween(from,to);
    }

    @Transactional(readOnly=true)
    public List<Dish> getSaleDishes() {
        return dishDAO.getSaleDishes();
    }
}
