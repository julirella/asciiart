package exporters.string

import java.io.{File, FileOutputStream}

class StringToFileExporter(file: File) extends OutputStreamStringExporter(new FileOutputStream(file)) {

}
