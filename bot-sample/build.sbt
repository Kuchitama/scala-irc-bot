
name := "bot-sample"

organization := "com.github.kuchitama"

version := "0.1-SNAPSHOT"
  
scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.2")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies := Seq(
  "com.typesafe" % "config" % "1.2.1",
  "ch.qos.logback" % "logback-classic" % "1.0.7",
  "net.mtgto" % "scala-irc-bot_2.10" % "0.3.0-SNAPSHOT"
)



