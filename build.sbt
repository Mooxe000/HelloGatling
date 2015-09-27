enablePlugins(GatlingPlugin)

name := "HelloScala"
version := "0.0.0"

scalaVersion := "2.11.7"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test"
