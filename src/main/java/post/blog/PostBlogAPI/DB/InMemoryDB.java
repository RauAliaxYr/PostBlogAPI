package post.blog.PostBlogAPI.DB;
import lombok.Getter;
import post.blog.PostBlogAPI.Model.PostModel;
import post.blog.PostBlogAPI.Model.UserModel;

import java.util.ArrayList;

@Getter
public class InMemoryDB {

    private final ArrayList<UserModel> users;
    private final ArrayList<PostModel> posts;

    public InMemoryDB() {
        this.users = new ArrayList<UserModel>();
        this.posts = new ArrayList<PostModel>();
    }

}
