package exporters.string

import java.io.OutputStream

class StringToOutputStreamExporter(os: OutputStream) extends StringExporter {
  protected def closeOS(): Unit = {
    os.close()
  }
  override def export(toExport: String): Unit = {
    os.write(toExport.getBytes("UTF-8"))
    os.flush()
    closeOS()
  }
}
