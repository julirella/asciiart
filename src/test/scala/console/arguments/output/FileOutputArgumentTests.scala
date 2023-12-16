package console.arguments.output

import exporters.string.StringToFileExporter
import org.scalatest.FunSuite

class FileOutputArgumentTests extends FunSuite{
  test("exporter instance created") {
    val argument = FileOutputArgument("path")
    val exporter = argument.createModule
    assert(exporter.isInstanceOf[StringToFileExporter])
  }

  test("non argument"){
    assertThrows[IllegalArgumentException] {
      FileOutputArgument("--error")
    }
  }
}
