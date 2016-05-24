import sbt._
import Keys._
import play.Play.autoImport._
import com.typesafe.sbt.web.SbtWeb.autoImport._
import com.typesafe.sbt.less.Import.LessKeys

object ApplicationBuild extends Build {

  val appName = "EagleEye"
  val appVersion = "1.0"

  lazy val resolverSettings = Seq(
    Resolver.mavenLocal,
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "Typesafe Akka snapshot repository" at "http://repo.akka.io/snapshots/",
   Resolver.sbtPluginRepo("releases")
  )

  val main = Project(appName, file("."))
    .enablePlugins(play.PlayJava)
    .settings(
      scalaVersion := "2.11.7",
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:reflectiveCalls"),
      version := appVersion,
      includeFilter in (Assets, LessKeys.less) := "*.less",
      libraryDependencies ++= Dependencies.eagle_eye,
      resolvers ++= resolverSettings
    )

}
