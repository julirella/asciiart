package console.arguments.load

import creators.loaders.ImageIOLoader
import org.scalatest.FunSuite

import java.io.{File, PrintWriter}

class ImageFromPathArgumentTests extends FunSuite{
  test("jpg path") {

    val path = "images/tests/tmp.jpg"
    val file = new File(path)
    val printWriter = new PrintWriter(file)
    val argument = ImageFromPathArgument(path)
    val imageLoader: ImageIOLoader = argument.createModule
    assert(imageLoader.path == file)
    file.delete()
  }

  test("png path") {
    val path = "images/tests/tmp.png"
    val file = new File(path)
    val printWriter = new PrintWriter(file)
    val argument = ImageFromPathArgument(path)
    val imageLoader: ImageIOLoader = argument.createModule
    assert(imageLoader.path == file)
    file.delete()
  }

  test("unsupported image format") {
    val path = "images/tests/tmp.bmp"
    val file = new File(path)
    val printWriter = new PrintWriter(file)
    assertThrows[IllegalArgumentException] {
      ImageFromPathArgument(path)
    }
    file.delete()
  }

  test("non existent file") {
    val nonExistingPath = "images/tests/tmp2.png"
    assertThrows[IllegalArgumentException] {
      ImageFromPathArgument(nonExistingPath)
    }
  }

}
