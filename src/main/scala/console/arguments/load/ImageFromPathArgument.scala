package console.arguments.load

import console.arguments.{Argument, ArgumentWithString}
import creators.Creator
import creators.loaders.ImageIOLoader
import models.images.RgbImage

import java.io.File


case class ImageFromPathArgument(path: String) extends ArgumentWithString(path) with LoadArgument {
  require(new File(path).exists(), "import image file doesn't exist")
  require(path.endsWith(".jpg") || path.endsWith(".png"), "illegal import file extension")

  override def createModule: ImageIOLoader = {
    new ImageIOLoader(new File(path))
  }
}
