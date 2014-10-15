package com.github.kuchitama

import net.mtgto.irc.{Bot, Client}
import net.mtgto.irc.event._
import net.mtgto.irc.config.BotConfig

class EchoBot() extends Bot {
  /**
    * 誰かがPRIVMSGを書いた時に通知される
   */
  override def onMessage(client: Client, message: Message) = {
    if (config.keywords.contains(message.text)) {
      // メッセージが送信されたチャンネルに同じメッセージをNOTICEで送り返す
      client.sendNotice(message.channel, message.text)
    }
  }
}
