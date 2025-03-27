package com.miti99.guessthepass.client;

import com.miti99.guessthepass.env.GuestThePassEnv;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;

public class GuestThePassClient extends OkHttpTelegramClient {
  public static final GuestThePassClient INSTANCE = new GuestThePassClient();

  private GuestThePassClient() {
    super(GuestThePassEnv.BOT_TOKEN);
  }
}
