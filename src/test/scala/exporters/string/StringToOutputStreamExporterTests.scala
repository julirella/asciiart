package exporters.string

import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, OutputStream}

class StringToOutputStreamExporterTests extends FunSuite{
  test("export string"){
    val os = new ByteArrayOutputStream()
    val exporter = new StringToOutputStreamExporter(os)
    exporter.export("words")
    assert(os.toString() == "words")
  }
}
