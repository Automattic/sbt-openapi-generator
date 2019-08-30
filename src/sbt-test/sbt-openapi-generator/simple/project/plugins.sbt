sys.props.get("plugin.version") match {
  case Some(x) =>
    addSbtPlugin("com.automattic" % "sbt-openapi-generator" % x)
  case _ => sys.error("Failed to specify a version")
}
