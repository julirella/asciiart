package asciiArtApp.console.arguments.output

import asciiArtApp.console.arguments.ArgumentWithString
import exporters.string.{StringExporter, StringToFileExporter}

import java.io.File

case class FileOutputArgument(path: String) extends ArgumentWithString(path) with OutputArgument{
  override def createModule: StringToFileExporter = {
    new StringToFileExporter(new File(path))
  }
}
