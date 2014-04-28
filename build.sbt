organization := "com.tegonal"

name := "play-airbrake"

version := "0.3.2-SNAPSHOT"

scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked", "-encoding", "UTF-8")

resolvers ++= Seq(
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.2.2" % "compile"
)

