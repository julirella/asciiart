package exporters.string

import org.scalatest.FunSuite

class StringToConsoleExporterTests extends FunSuite{
  test("export to console"){
    //TODO: can it not be a visual test?
    val exporter = new StringToConsoleExporter()
    val str = "some string\nanother string"
    exporter.export(str)
  }
}
