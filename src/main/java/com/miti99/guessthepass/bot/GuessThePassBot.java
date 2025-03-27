package com.miti99.guessthepass.bot;

import com.miti99.guessthepass.client.GuestThePassClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GuessThePassBot implements LongPollingSingleThreadUpdateConsumer {
  @Override
  public void consume(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      var sendMessage =
          new SendMessage(
              update.getMessage().getChatId().toString(), update.getMessage().getText());
      try {
        GuestThePassClient.INSTANCE.execute(sendMessage);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }
}
