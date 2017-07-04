package line.bot.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import line.bot.sample.common.exception.AuthenticationException;

/**
 *
 * {@link line.bot.sample.controller} 内で発生した例外をハンドリングするクラスです。
 * 例外クラスの種類毎に振る舞いを設定することが可能です。
 *
 */
@ControllerAdvice
public class ExceptionHandler {

	/**
	 * 認証エラー例外が発生した場合に呼び出されます。
	 * レスポンスとしてJSONを返さない場合の設定です。
	 */
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@org.springframework.web.bind.annotation.ExceptionHandler({ AuthenticationException.class })
	public void handleForbidden() {

	}

	/**
	 * パラメータ不正例外が発生した場合の呼び出されます。
	 * レスポンスとしてJSONを返す場合の設定です。
	 *
	 * @param e {@link IllegalArgumentException}
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler({ IllegalArgumentException.class })
	@ResponseBody
	public Map<String, Object> handleBadRequest(IllegalArgumentException e) {
		Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("message", e.getMessage());
        return errorMap;
	}
}
