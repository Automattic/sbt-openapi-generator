lazy val root = (project in file(".")).enablePlugins(SbtPlugin).settings(
  name := "sbt-openapi-generator",
  organization := "com.automattic",
  version := "0.1_4.1.1-SNAPSHOT",
  sbtPlugin := true,
  description := "Plugin to create clients with an open api spec",
  libraryDependencies ++= Seq(
    "org.openapitools" % "openapi-generator" % "4.1.1"
  ),
  scriptedLaunchOpts := { scriptedLaunchOpts.value ++
    Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
  },
  scriptedBufferLog := false
)
