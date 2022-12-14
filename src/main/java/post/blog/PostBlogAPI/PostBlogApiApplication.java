package post.blog.PostBlogAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import post.blog.PostBlogAPI.DB.InMemoryDB;
import post.blog.PostBlogAPI.Model.PostModel;
import post.blog.PostBlogAPI.Model.UserModel;

import java.util.ArrayList;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RestController
public class PostBlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostBlogApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
