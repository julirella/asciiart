package asciiArtApp.console.arguments.output

import exporters.string.{StringExporter, StringToConsoleExporter}

case class ConsoleOutputArgument() extends OutputArgument {
  override def createModule: StringToConsoleExporter = {
    new StringToConsoleExporter()
  }
}
