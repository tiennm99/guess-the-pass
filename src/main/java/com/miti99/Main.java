package com.miti99;

import com.miti99.guessthepass.bot.GuessThePassBot;
import com.miti99.guessthepass.env.GuestThePassEnv;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Log4j2
public class Main {

  public static void main(String[] args) {
    try {
      var botsApplication = new TelegramBotsLongPollingApplication();
      botsApplication.registerBot(GuestThePassEnv.BOT_TOKEN, new GuessThePassBot());
    } catch (TelegramApiException e) {
      log.error(e);
    }
  }
}
