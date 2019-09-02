val generatorVersion = "4.1.1"
val pluginVersion = "0.1"

ThisBuild / version := s"$pluginVersion.$generatorVersion"
ThisBuild / organization := "com.automattic"
ThisBuild / description := "Generates clients with an open api spec"
ThisBuild / licenses += ("GPL-3.0", url("https://www.gnu.org/licenses/gpl-3.0.en.html"))
ThisBuild / bintrayReleaseOnPublish := false

lazy val root = (project in file(".")).enablePlugins(SbtPlugin).settings(
  name := "sbt-openapi-generator",
  sbtPlugin := true,
  description := "Plugin to create clients with an open api spec",
  bintrayRepository := "generic",
  bintrayOrganization := Some("automattic"),
  libraryDependencies ++= Seq(
    "org.openapitools" % "openapi-generator" % generatorVersion
  ),
  scriptedLaunchOpts := { scriptedLaunchOpts.value ++
    Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
  },
  scriptedBufferLog := false
)
