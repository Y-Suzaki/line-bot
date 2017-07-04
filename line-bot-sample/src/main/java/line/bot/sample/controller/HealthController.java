package line.bot.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import line.bot.sample.service.HealthService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HealthController {

	@Autowired
	private HealthService healthService;

	@RequestMapping(path="/health.json")
    public void health() {
       healthService.check();
    }
}
