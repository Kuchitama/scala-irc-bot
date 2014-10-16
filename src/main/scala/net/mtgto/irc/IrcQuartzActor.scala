package net.mtgto.irc

import akka.actor.Actor
import org.slf4j.LoggerFactory

class IrcQuartzActor extends Actor{
  lazy val logger = LoggerFactory.getLogger(this.getClass)

  def receive = {
    case (client: Client, bot: Bot) => bot.onSchedule(client)
    case m => logger.debug(s"unknown message received: ${m}")
  }

}
