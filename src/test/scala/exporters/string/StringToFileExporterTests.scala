package exporters.string

import org.scalatest.FunSuite

import java.io.{File, PrintWriter}
import scala.io.Source

//https://stackoverflow.com/questions/1284423/read-entire-file-in-scala
class StringToFileExporterTests extends FunSuite{
  test("write to empty file"){
    val fileName = "images/exporterTest.txt"
    val file = new File(fileName)
    val exporter = new StringToFileExporter(file)
    val str = "some string"
    exporter.export(str)

    val source = scala.io.Source.fromFile(fileName)
    val result = try source.mkString finally source.close()
    file.delete()

    assert(result == str)
  }

  test("overwrite file"){
      val fileName = "images/exporterTest.txt"
      val file = new File(fileName)
      val printWriter = new PrintWriter(file)
      printWriter.write("wrong text")
      printWriter.close()

      val exporter = new StringToFileExporter(file)
      val str = "some string"
      exporter.export(str)

      val source = scala.io.Source.fromFile(fileName)
      val result = try source.mkString finally source.close()
      file.delete()

      assert(result == str)
  }
}
