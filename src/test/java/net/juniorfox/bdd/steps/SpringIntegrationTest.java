package net.juniorfox.bdd.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import net.juniorfox.Application;
import net.juniorfox.adapter.client.BoredApi;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = Application.class)
@CucumberContextConfiguration
@MockitoBean(types = {BoredApi.class})
public class SpringIntegrationTest {
}
