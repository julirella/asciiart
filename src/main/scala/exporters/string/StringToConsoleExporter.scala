package exporters.string

class StringToConsoleExporter extends StringToOutputStreamExporter(System.out){
  //do not close console stream because of sbt
  override protected def closeOS(): Unit = {}
}
