package post.blog.PostBlogAPI.Model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Getter
@Setter
@Entity
public class PostUser {


    @Id
    private String id;

    @Column(nullable = false)
    private String name;


    public PostUser() {
        Random random = new Random();
        this.id = random.nextInt(100) + "ID" + random.nextInt(250);
    }


}
