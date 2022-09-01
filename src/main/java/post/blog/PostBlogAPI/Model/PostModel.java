package post.blog.PostBlogAPI.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;

@Entity
@Getter
@Setter
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String text;

    @Column
    private String data;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

}
