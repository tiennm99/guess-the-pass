package com.miti99;

import com.miti99.guessthepass.bot.GuessThePassBot;
import com.miti99.guessthepass.env.GuestThePassEnv;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class Main {

  public static void main(String[] args) {
    try {
      var botsApplication = new TelegramBotsLongPollingApplication();
      botsApplication.registerBot(GuestThePassEnv.BOT_TOKEN, new GuessThePassBot());
    } catch (TelegramApiException e) {
      log.error("botsApplication start failed", e);
    }
  }
}
