package line.bot.sample.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HealthService {

	/**
	 * アプリケーションが正常に動作しているかをチェックします。
	 * チェックに失敗した場合、例外をthrowするようにしてください。
	 */
	public void check() {
        log.debug("health check success.");
	}
}
