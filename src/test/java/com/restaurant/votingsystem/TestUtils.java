package com.restaurant.votingsystem;

import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.model.Restaurant;
import com.restaurant.votingsystem.model.Role;
import com.restaurant.votingsystem.model.User;

import java.math.BigDecimal;
import java.util.List;

public class TestUtils {
    public static final int GLOB_SEQ_DISH = 1000;

    public static final int USER_ID = 1000;
    public static final int ADMIN_ID = 2000;
    //Vesuvio
    public static final int REST_ID = 1000;
    public static final int DISH_ID = 1000;


    public static final User USER = new User(USER_ID, "User", "userpassword", "User@gmail.com",null, Role.USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "adminpassword", "Admin@gmail.com",null, Role.ADMIN, Role.USER);

    public static User getNewUser(){
        return new User(null, "NewUser", "userpassword", "newUser@gmail.com",1, Role.USER);
    }

    public static Restaurant getNewRestaurant(){
        return new Restaurant(null,"NewRest");
    }
    public static Dish getNewDish() {
        Dish newDish = new Dish(null, "NewDish", new BigDecimal(100));
        newDish.setRestaurant(GONG);
        return newDish;
    }

    public static Dish getDishWithRest() {
        Dish newDish = new Dish(GLOB_SEQ_DISH, "Zitti", new BigDecimal(12));
        newDish.setRestaurant(VESUVIO);
        return newDish;
    }

    public static final  Restaurant VESUVIO = new Restaurant(1000,"VESUVIO");
    public static final  Restaurant GONG = new Restaurant(2000,"GONG");
    public static final List<Restaurant> RESTAURANTS = List.of(GONG, VESUVIO);

    public static final Dish DISH_1 = new Dish(GLOB_SEQ_DISH, "Zitti", new BigDecimal(12));
    public static final Dish DISH_2 = new Dish(GLOB_SEQ_DISH + 1,"Prosciutto pizza", new BigDecimal(15));
    public static final Dish DISH_3 = new Dish(GLOB_SEQ_DISH + 2, "Tiramisu", new BigDecimal(7));
    public static final Dish DISH_4 = new Dish(GLOB_SEQ_DISH + 3, "Limonchello", new BigDecimal(8));

    public static final Dish DISH_5 = new Dish(GLOB_SEQ_DISH + 4,"Chicken Teriyaki", new BigDecimal(15));
    public static final Dish DISH_6 = new Dish(GLOB_SEQ_DISH + 5,"Pad tai", new BigDecimal(10));
    public static final Dish DISH_7 = new Dish(GLOB_SEQ_DISH + 6,"Tom Kha", new BigDecimal(15));
    public static final Dish DISH_8 = new Dish(GLOB_SEQ_DISH + 7,"Sodju", new BigDecimal(8));

    public static final  List<Dish> VESUVIO_MENU_BY_PRICE = List.of(DISH_3, DISH_4, DISH_1, DISH_2);
    public static final  List<Dish> ALL_DISHES = List.of(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7, DISH_8);

//    public static final Dish dish1 = new Dish(GLOB_SEQ + 1,"Seafood pasta", new BigDecimal(25));
//    public static final Dish dish2 = new Dish(GLOB_SEQ + 2,"Salmon steak", new BigDecimal(30));
//    public static final Dish dish3 = new Dish(GLOB_SEQ + 3,"White wine", new BigDecimal(7));
//    public static final Dish dish4 = new Dish(GLOB_SEQ + 4,"Fried shrimps", new BigDecimal(15));
//    public static final List<Dish> SEAFOOD_DISHES = List.of(dish1, dish2, dish3, dish4);
//    public static final Restaurant SEAFOOD_RESTAURANT = new Restaurant(3000, "Sea Wave");
//
//    public static final Dish dish5 = new Dish(GLOB_SEQ + 5,"Caesar Salad", new BigDecimal(10));
//    public static final Dish dish6 = new Dish(GLOB_SEQ + 6,"Pumpkin soup", new BigDecimal(8));
//    public static final Dish dish7 = new Dish(GLOB_SEQ + 7,"Red wine", new BigDecimal(6));
//    public static final Dish dish8 = new Dish(GLOB_SEQ + 8,"Coffee and Cheesecake", new BigDecimal(12));
//    public static final List<Dish> EUROPEAN_DISHES = List.of(dish5, dish6, dish7, dish8);
//    public static final Restaurant EUROPEAN_RESTAURANT = new Restaurant(4000, "Europe");


}
