package com.tsvietkovich.dao;

import com.tsvietkovich.model.Dish;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DishDAOImpl implements DishDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addDish(Dish dish) {
        entityManager.merge(dish);
    }

    @Override
    public void deleteDish(int[] ids) {
        Dish dish;
        for(int id: ids){
            dish = entityManager.getReference(Dish.class, id);
            entityManager.remove(dish);
        }
    }

    @Override
    public Dish getDishByID(int id) {
        return entityManager.find(Dish.class,id);
    }

    @Override
    public void upDateDish(Dish dish, String name,Double price, Double weight, String sale) {
        dish.setName(name);
        dish.setPrice(price);
        dish.setWeight(weight);
        dish.setSale(sale);
        entityManager.merge(dish);
    }

    @Override
    public List<Dish> getDishesBetween(Double from, Double to) {
        TypedQuery<Dish> query = entityManager.createQuery("select d from Dish d where d.price BETWEEN :min and :max", Dish.class);
        query.setParameter("min", from);
        query.setParameter("max", to);
        return query.getResultList();
    }

    @Override
    public List<Dish> getSaleDishes() {
        TypedQuery<Dish> query = entityManager.createQuery("select d from Dish d where d.sale = :s", Dish.class);
        query.setParameter("s","sale");
        return query.getResultList();
    }

    @Override
    public List<Dish> getAllDishes() {
        TypedQuery<Dish>query = entityManager.createQuery("select d from Dish d", Dish.class);
        return  query.getResultList();
    }


    @Override
    public List<Dish> getDishesUnderWeight(Double weight) {
        List<Dish> resultList = new LinkedList<Dish>();
        TypedQuery<Dish> selectAll = entityManager.createQuery("select d from Dish d where d.weight <= :w", Dish.class);
        selectAll.setParameter("w",weight);
        List<Dish> dishes = selectAll.getResultList();
        int sum =0;
        for(Dish d: dishes){
            sum+=d.getWeight();
            if(sum<=weight){
                resultList.add(d);
            }
        }
        return resultList;
    }
}
