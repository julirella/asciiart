package exporters.string

import java.io.OutputStream

class StringToOutputStreamExporter(os: OutputStream) extends StringExporter {
  override def export(toExport: String): Unit = {
    os.write(toExport.getBytes("UTF-8"))
    os.flush()
//    os.close()
  }
}
