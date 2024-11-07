ThisBuild / organization := "com.siriusxm.example"
ThisBuild / scalaVersion := "2.13.15"

// automatically reload sbt config when this file changes
Global / onChangedBuildSource := ReloadOnSourceChanges

// this silences a thread warning when running on an interactive sbt session
Compile / run / fork := true

lazy val root = project
  .in(file("."))
  .settings(
    name := "shopping-cart-test",
    libraryDependencies ++= Seq(
      // this pulls in the kernel and std modules automatically
      "org.typelevel" %% "cats-effect" % "3.5.5",
      // for making our product requests
      "org.http4s"    %% "http4s-ember-client" % "0.23.29",
      // this pulls in the latest munit as well
      "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test,
      // better-monadic-for compiler plugin as suggested by CE documentation
      compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    ),
    // enable warnings for non-unit statements
    scalacOptions += "-Wnonunit-statement"
  )
