package line.bot.sample.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TextService {

	public String repeatMessage(String message) {
		log.debug("repeat message {}.", message);
        return message;
	}
}
