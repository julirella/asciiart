package console.arguments.output

import exporters.string.StringToConsoleExporter
import org.scalatest.FunSuite

class ConsoleOutputArgumentTests extends FunSuite{
  test("exporter instance created") {
    val argument = ConsoleOutputArgument()
    val exporter = argument.createModule
    assert(exporter.isInstanceOf[StringToConsoleExporter])
  }
}
