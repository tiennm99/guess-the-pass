package com.miti99;

import com.miti99.guessthepass.bot.GuessThePassBot;
import com.miti99.guessthepass.env.GuestThePassEnv;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

  public static void main(String[] args) {
    try {
      var botsApplication = new TelegramBotsLongPollingApplication();
      botsApplication.registerBot(GuestThePassEnv.BOT_TOKEN, new GuessThePassBot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
