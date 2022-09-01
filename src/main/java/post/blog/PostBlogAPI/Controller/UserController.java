package post.blog.PostBlogAPI.Controller;


import org.springframework.web.bind.annotation.*;
import post.blog.PostBlogAPI.DB.InMemoryDB;
import post.blog.PostBlogAPI.Model.PostUser;

import java.util.ArrayList;
import java.util.Objects;


@RestController

public class UserController {

    InMemoryDB db = new InMemoryDB(new ArrayList<PostUser>());


    @GetMapping("/users")
    public ArrayList<PostUser> getAllPerson(){

        return db.getArray();
    };

    @GetMapping("/users/{id}")
    public PostUser getAllPerson(@PathVariable String id){
        ArrayList<PostUser> arr = db.getArray();
        return Objects.requireNonNull(arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null));
    };


    @PostMapping("/users")
    public PostUser postPerson(@RequestBody PostUser name){

        PostUser user = new PostUser();
        user.setName(name.getName());
        ArrayList<PostUser> arr = db.getArray();
        arr.add(user);

        return user;
    };




    @PutMapping("/users/{id}")
    public ArrayList<PostUser> updatePerson(@RequestBody PostUser name,@PathVariable String id){

        System.out.println(name +"  "+ id);
        ArrayList<PostUser> arr = db.getArray();
        Objects.requireNonNull(arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null)).setName(name.getName());

        return db.getArray();
    };


    @DeleteMapping("/users/{id}")
    public ArrayList<PostUser> deletePerson(@PathVariable String id){

        ArrayList<PostUser> arr = db.getArray();
        PostUser user = arr.stream().filter(userId -> userId.getId().equals(id)).findFirst().orElse(null);
        arr.remove(user);

        return db.getArray();
    };

}
