package com.github.kuchitama.irc

import net.mtgto.irc.{Client, Bot}
import com.typesafe.config.Config
import scala.collection.JavaConverters._
import java.text.SimpleDateFormat
import java.util.Date

/**
 * This bot send notice at every hour like @kiri_tori(https://twitter.com/kiri_tori).
 *
 * sample config
 * {name: "com.github.kuchitama.irc.KiritoriBot", config: {channels: ${irc.channels}}}
 */
class KiritoriBot(config: Config) extends Bot{

  lazy val channels:List[String] = config.getStringList("channels").asScala.toList

  private val Format = "MM/dd HH:mm"

  override val quartzSetting:Option[String] = Some("0 0 * * * ?")

  override def onSchedule(client: Client) = {
    for( channel <- channels) {
      client.sendNotice(channel, s"✄---------- ${new SimpleDateFormat(Format).format(new Date())} ----------✄")
    }
  }
}
