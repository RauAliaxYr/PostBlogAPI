package post.blog.PostBlogAPI.Controller;

import org.springframework.web.bind.annotation.*;
import post.blog.PostBlogAPI.DB.InMemoryDB;
import post.blog.PostBlogAPI.Model.PostModel;

import java.util.ArrayList;
import java.util.Objects;

public class PostController {

    InMemoryDB db;

    @GetMapping("/posts")
    public ArrayList<PostModel> getAllPerson(){

        return db.getPosts();
    };

    @GetMapping("/posts/{id}")
    public PostModel getAllPerson(@PathVariable String id){
        ArrayList<PostModel> arr = db.getPosts();
        return Objects.requireNonNull(arr.stream().filter(postId -> postId.getId().equals(id)).findFirst().orElse(null));
    };


    @PostMapping("/posts")
    public PostModel postPerson(@RequestBody PostModel post){

        PostModel newPost = new PostModel();
        post.setText(post.getText());
        post.setUser(post.getUser());
        db.getPosts().add(newPost);

        return newPost;
    };


    @PutMapping("/posts/{id}")
    public ArrayList<PostModel> updatePerson(@RequestBody PostModel post, @PathVariable String id){


        ArrayList<PostModel> arr = db.getPosts();
        Objects.requireNonNull(arr.stream().filter(postId -> postId.getId().equals(id)).findFirst().orElse(null)).setText(post.getText());

        return db.getPosts();
    };


    @DeleteMapping("/posts/{id}")
    public ArrayList<PostModel> deletePerson(@PathVariable String id){

        ArrayList<PostModel> arr = db.getPosts();
        PostModel post = arr.stream().filter(postId -> postId.getId().equals(id)).findFirst().orElse(null);
        arr.remove(post);

        return db.getPosts();
    };
}
