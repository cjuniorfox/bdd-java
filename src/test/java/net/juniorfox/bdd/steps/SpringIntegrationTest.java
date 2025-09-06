package net.juniorfox.bdd.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import net.juniorfox.adapter.client.BoredApi;
import net.juniorfox.adapter.controller.BoringController;
import net.juniorfox.application.service.impl.BoringServiceImpl;
import net.juniorfox.bdd.ApplicationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {
        BoringController.class,
        BoringServiceImpl.class,
        ApplicationTest.class}
)
@CucumberContextConfiguration
@MockitoBean(types = {BoredApi.class})
public class SpringIntegrationTest {
}
