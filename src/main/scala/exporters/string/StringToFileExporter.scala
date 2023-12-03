package exporters.string

import java.io.{File, FileOutputStream}

class StringToFileExporter(file: File) extends StringToOutputStreamExporter(new FileOutputStream(file)) {

}
