package post.blog.PostBlogAPI.Controller;


import org.springframework.web.bind.annotation.*;
import post.blog.PostBlogAPI.DB.InMemoryDB;
import post.blog.PostBlogAPI.Model.PostModel;
import post.blog.PostBlogAPI.Model.UserModel;

import java.util.ArrayList;
import java.util.Objects;


@RestController
public class UserController {


    InMemoryDB db;


    @GetMapping("/users")
    public ArrayList<UserModel> getAllPerson(){

        return db.getUsers();
    };

    @GetMapping("/users/{id}")
    public UserModel getAllPerson(@PathVariable String id){
        ArrayList<UserModel> arr = db.getUsers();
        return Objects.requireNonNull(arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null));
    };


    @PostMapping("/users")
    public UserModel postPerson(@RequestBody UserModel name){

        UserModel user = new UserModel();
        user.setName(name.getName());
        ArrayList<UserModel> arr = db.getUsers();
        arr.add(user);

        return user;
    };


    @PutMapping("/users/{id}")
    public ArrayList<UserModel> updatePerson(@RequestBody UserModel name, @PathVariable String id){


        ArrayList<UserModel> arr = db.getUsers();
        Objects.requireNonNull(arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null)).setName(name.getName());

        return db.getUsers();
    };


    @DeleteMapping("/users/{id}")
    public ArrayList<UserModel> deletePerson(@PathVariable String id){

        ArrayList<UserModel> arr = db.getUsers();
        UserModel user = arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null);
        arr.remove(user);

        return db.getUsers();
    };

}
