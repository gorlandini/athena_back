package com;

import com.google.cloud.spring.autoconfigure.datastore.GcpDatastoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(

) // desativa todo o Datastore
public class AthenaApplication {




	public static void main(String[] args) {
		SpringApplication.run(AthenaApplication.class, args);
	}

}
