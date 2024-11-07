ThisBuild / organization := "com.siriusxm.example"
ThisBuild / scalaVersion := "2.13.15"

val catsV = "2.12.0"
val catsEffectV = "3.5.5"
val circeV = "0.14.10"
val http4sV = "0.23.29"
val log4catsV = "2.7.0"
val logbackClassicV = "1.5.6"
val munitCatsEffectV = "2.0.0"
val betterMonadicForV = "0.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "shopping-cart-test",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"           % catsV,
      "org.typelevel" %% "cats-effect"         % catsEffectV,
      "io.circe"      %% "circe-core"          % circeV,
      "io.circe"      %% "circe-generic"       % circeV,
      "io.circe"      %% "circe-parser"        % circeV,
      "org.http4s"    %% "http4s-client"       % http4sV,
      "org.http4s"    %% "http4s-ember-client" % http4sV,
      "org.http4s"    %% "http4s-circe"        % http4sV,
      "org.typelevel" %% "log4cats-slf4j"      % log4catsV,
      "ch.qos.logback" % "logback-classic"     % logbackClassicV  % Runtime,
      "org.typelevel" %% "munit-cats-effect"   % munitCatsEffectV % Test,
      // as suggested by CE documentation
      compilerPlugin("com.olegpy" %% "better-monadic-for" % betterMonadicForV),
    ),
    // enable warnings for non-unit statements
    scalacOptions += "-Wnonunit-statement"
  )

// automatically reload sbt config when this file changes
Global / onChangedBuildSource := ReloadOnSourceChanges

// this silences a thread warning when running on an interactive sbt session
Compile / run / fork := true

