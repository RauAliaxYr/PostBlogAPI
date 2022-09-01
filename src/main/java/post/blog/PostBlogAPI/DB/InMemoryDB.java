package post.blog.PostBlogAPI.DB;
import lombok.Getter;
import post.blog.PostBlogAPI.Model.PostUser;

import java.util.ArrayList;

@Getter
public class InMemoryDB {

    private ArrayList<PostUser> array;

    public InMemoryDB(ArrayList<PostUser> array) {
        this.array = array;
    }

}
