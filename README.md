# Open API Generator Plugin

This uses the [open api generator](https://github.com/OpenAPITools/openapi-generator)
to output a client from a swagger/open api spec.

Example `build.sbt`

```scala
lazy val root = (project in file("."))
  .enablePlugins(GeneratorPlugin)
  .settings(
    scalaVersion := "2.11.12",
    version := "0.1",
    generatorConfig := file("src/config.yml"),
    generatorSpec := file("src/echo.yml"),
    generatorOutput := file("target/php-client"),
    generatorLanguage := "php"
  )
```

Example `project/plugins.sbt`:

```scala
addSbtPlugin("com.automattic" % "sbt-openapi-generator" % "0.1_4.1.1-SNAPSHOT")
```

# Testing

This project uses the sbt-scripted plugin, so run `sbt scripted` to run
tests against the project defined in `src/sbt-test`.