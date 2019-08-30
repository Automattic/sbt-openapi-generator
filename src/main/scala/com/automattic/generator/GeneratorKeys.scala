package com.automattic.generator

import sbt._

trait GeneratorKeys {
  lazy val generatorConfig = settingKey[File]("Generator Configuration")
  lazy val generatorSpec = settingKey[File]("Location where the spec lives")
  lazy val generatorOutput = settingKey[File]("Where to output the client")
  lazy val generatorLanguage = settingKey[String]("Language to generate a client with")
  lazy val generateClient = taskKey[Unit]("Generate a client from a configuration")
}
