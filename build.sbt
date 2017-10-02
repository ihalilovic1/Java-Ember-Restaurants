name := "restaurants"
 
version := "1.0" 
      
lazy val `restaurants` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs ,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42", javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies += evolutions

PlayKeys.externalizeResources := false