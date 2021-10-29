package com.cisco.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableCaching
@EnableHypermediaSupport(type = HypermediaType.HAL_FORMS)
//@EnableScheduling
public class OrderappApplication {
	
//	@Autowired
//	CacheManager manager;
//	
//	@Scheduled(fixedDelay = 5000)
//	@CacheEvict(value = "productCache", allEntries = true)
//	public void doTask() {
//		Collection<String> names = manager.getCacheNames();
//		for(String name : names) {
//			manager.getCache(name).clear();
//		}
//	}
	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

}
