package com.tsvietkovich.controllers;

import com.tsvietkovich.model.Dish;
import com.tsvietkovich.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class DishController {
    @Autowired
    private DishService dishService;

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */

    @RequestMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("index", "command", new Dish());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveDish(@ModelAttribute("dish") Dish dish) {
        dishService.addDish(dish);
        return new ModelAndView("redirect:/viewAll");
    }
    @RequestMapping("/viewAll")
    public ModelAndView viewDishes(){
        List<Dish> list=dishService.getAllDishes();
        return new ModelAndView("viewAll","list",list);
    }


    @RequestMapping(value="/delete_selected", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSelected(@RequestParam(value = "toDelete[]", required = false) int[] ids) {
        dishService.deleteDish(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/get_category")
    public String selectCategory(){
        return "get_between";
    }

    @RequestMapping(value="/dishes_between", method = RequestMethod.POST)
    public ModelAndView viewDishesBetweenPrices(@RequestParam(value="from",required = false) Double from,
                                                @RequestParam(value="to", required = false) Double to ) {
        List<Dish> list = dishService.getDishesBetween(from,to);
        return new ModelAndView("viewAll","list",list);
    }
    @RequestMapping(value = "/viewSale", method = RequestMethod.POST)
    public ModelAndView viewSaleDishes(){
        List<Dish> list=dishService.getSaleDishes();
        return new ModelAndView("viewAll","list",list);
    }
    @RequestMapping(value="/dishes_underWeight", method = RequestMethod.POST)
    public ModelAndView viewDishesUnderWeight(@RequestParam(value="under", required = false) Double under ) {
        List<Dish> list = dishService.getDishesUnderWeight(under);
        return new ModelAndView("viewAll","list",list);
    }
    @RequestMapping(value="/edit_dish/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        Dish dish = dishService.getDishByID(id);
        model.addAttribute(dish);
        return "editform";
    }

    @RequestMapping(value="/edit_save/{id}", method = RequestMethod.POST)
    public String editSave(@PathVariable("id") int id,
                           @RequestParam(required = false) String name ,
                           @RequestParam(required = false) Double price,
                           @RequestParam(required = false) Double weight,
                           @RequestParam(required = false) String sale) {
        Dish dishByID = dishService.getDishByID(id);
        dishService.updateDish(dishByID,name,price,weight,sale);

        return "redirect:/viewAll";
    }

}
