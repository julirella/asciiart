package exporters.string

import org.scalatest.FunSuite

class StringToConsoleExporterTests extends FunSuite{
  //just a visual test
  test("export to console"){
    val exporter = new StringToConsoleExporter()
    val str = "some string\nanother string"
    exporter.export(str)
  }
}
