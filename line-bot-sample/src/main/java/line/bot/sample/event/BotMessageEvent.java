package line.bot.sample.event;

import org.springframework.beans.factory.annotation.Autowired;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import line.bot.sample.service.StickerService;
import line.bot.sample.service.TextService;
import line.bot.sample.service.WeatherService;
import lombok.extern.slf4j.Slf4j;

@LineMessageHandler
@Slf4j
public class BotMessageEvent {

    @Autowired
    private TextService textService;

    @Autowired
    private StickerService stickerService;

    @Autowired
    private WeatherService weatherService;

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
    	String message = textService.repeatMessage(event.getMessage().getText());
        return new TextMessage(message);
    }

    @EventMapping
    public Message handleStickerMessage(MessageEvent<StickerMessageContent> event) {
    	log.debug(event.toString());

    	return new TextMessage("スタンプの送信ありがとうございます。");
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        log.debug(event.toString());
    }
}
