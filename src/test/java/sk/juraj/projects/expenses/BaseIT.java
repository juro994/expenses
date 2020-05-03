package sk.juraj.projects.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	protected TestRestTemplate restTemplate;
	
	protected String getUrlBase() {
		return "http://localhost:" + port + "/expenses/";
	}

}
