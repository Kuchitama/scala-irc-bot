package com.github.kuchitama.irc

import net.mtgto.irc.{Bot, Client}
import net.mtgto.irc.event._
import com.typesafe.config.Config
import scala.collection.JavaConverters._

class EchoBot(config: Config) extends Bot {

  private val keywords:List[String] = config.getStringList("keywords").asScala.toList

  /**
    * 誰かがPRIVMSGを書いた時に通知される
   */
  override def onMessage(client: Client, message: Message) = {
    if (keywords.contains(message.text)) {
      // メッセージが送信されたチャンネルに同じメッセージをNOTICEで送り返す
      client.sendNotice(message.channel, message.text)
    }
  }
}
