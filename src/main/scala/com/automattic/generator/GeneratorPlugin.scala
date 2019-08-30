package com.automattic.generator

import java.util

import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.config.CodegenConfigurator
import sbt.{Def, _}
import sbt.Keys.{sLog, target}

object GeneratorPlugin extends AutoPlugin {
  override val trigger: PluginTrigger = noTrigger
  override val requires: Plugins = plugins.JvmPlugin

  object autoImport extends GeneratorKeys

  import autoImport._

  override val projectSettings: Seq[Setting[_]] = Seq(
    generateClient := generateClientTask.value,
    generatorOutput := target.value
  )

  private def generateClientTask = Def.task {
    val configFile = generatorConfig.value.getAbsolutePath
    var config = CodegenConfigurator.fromFile(configFile)

    if (config == null) config = new CodegenConfigurator()

    val spec = generatorSpec.value.getAbsolutePath
    config.setInputSpec(spec)

    val generatorName = generatorLanguage.value
    config.setGeneratorName(generatorName)

    val outputDir = generatorOutput.value.getAbsolutePath
    config.setOutputDir(outputDir)

    val clientOutput = config.toClientOptInput
    new DefaultGenerator().opts(clientOutput).generate()
  }
}
