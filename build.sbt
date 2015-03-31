name := "recursive-touch"

scalaVersion := "2.11.6"

libraryDependencies += "de.sciss" %% "fileutil" % "1.1.1"

target in assembly := baseDirectory.value

assemblyJarName in assembly := s"${name.value}.jar"
