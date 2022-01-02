package com.audit.springjwt;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import com.audit.springjwt.model.User;
import com.audit.springjwt.repository.UserRepository;*/

@SpringBootApplication
public class SpringjwtApplication  {
	
	/*
	 * public class SpringjwtApplication implements CommandLineRunner 
	 * @Autowired UserRepository repository;
	 */

	public static void main(String[] args)  {
		SpringApplication.run(SpringjwtApplication.class, args);
	}
	
	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * long count = repository.count();
	 * 
	 * if (count == 1) { repository.save(new User(1L,"test@test.com",
	 * "$2a$04$vxl4fJ..bQufnbkVqAmbdOcXZIyw9fEOw31iGQg8vhJuQ4Cbe9Yiu","surya")); } }
	 */

}
