package console.arguments.output

import console.arguments.ArgumentWithString
import exporters.string.{StringExporter, StringToFileExporter}

import java.io.File

case class FileOutputArgument(path: String) extends ArgumentWithString(path) with OutputArgument{
  override def createModule: StringExporter = {
    new StringToFileExporter(new File(path))
  }
}
