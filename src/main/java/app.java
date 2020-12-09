import com.google.gson.Gson;
import dao.Sql2oFoodtypeDao;
import dao.Sql2oRestaurantDao;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class app {
    public static void main (String[] args){
        Sql2oFoodtypeDao foodtypeDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oRestaurantDao reviewDao;
        Connection conn;
        Gson gson =new Gson();


        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Nya2rango@");

        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oRestaurantDao(sql2o);
        conn = sql2o.open();


        post("/restaurants/new", "application/json", (req, res) ->{
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
            restaurantDao.add(restaurant);
            res.status(201);
            res.type("application/json");
            return gson.toJson(restaurant);
        });

        //CREATE
        post("/restaurants/new", "application/json", (req, res) -> {
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
            restaurantDao.add(restaurant);
            res.status(201);;
            return gson.toJson(restaurant);
        });

        //READ
        get("/restaurants", "application/json", (req, res) -> {
            return gson.toJson(restaurantDao.getAll());
        });

        get("/restaurants/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(restaurantDao.findById(restaurantId));
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });

//        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) -> {
//            int restaurantId = Integer.parseInt(req.params("restaurantId"));
//            Review review = gson.fromJson(req.body(), Review.class);
//
//            review.setRestaurantId(restaurantId); //we need to set this separately because it comes from our route, not our JSON input.
//            reviewDao.add(review);
//            res.status(201);
//            return gson.toJson(review);
//        });



    }
}
