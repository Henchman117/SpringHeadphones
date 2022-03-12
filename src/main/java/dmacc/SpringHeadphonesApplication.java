package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Headphone;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.HeadphoneRepository;

@SpringBootApplication
public class SpringHeadphonesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringHeadphonesApplication.class, args);

	}
	
	@Autowired
	HeadphoneRepository repo;
	
	@Override
	public void run(String... args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Headphone h = appContext.getBean("headphone",Headphone.class);
	
		repo.save(h);
		
		Headphone h2 = new Headphone("400i", 360, "planar", 110);
		
		repo.save(h2);
		
		List<Headphone> allHeadphones = repo.findAll();
		for(Headphone headphone: allHeadphones) {
			System.out.println(headphone.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}

}
