lazy val root = (project in file("."))
  .enablePlugins(GeneratorPlugin)
  .settings(
    scalaVersion := "2.11.12",
    version := "0.1",
    generatorConfig := file("src/config.yml"),
    generatorSpec := file("src/echo.yml"),
    generatorLanguage := "php"
  )
