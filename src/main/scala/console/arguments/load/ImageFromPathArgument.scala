package console.arguments.load

import console.arguments.{Argument, ArgumentWithString}
import creators.Creator
import creators.loaders.ImageIOLoader
import models.images.RgbImage

import java.io.File


case class ImageFromPathArgument(path: String) extends ArgumentWithString(path) with LoadArgument {
  if(!new File(path).exists()) throw new IllegalArgumentException("import image file doesn't exist")
  if(!(path.endsWith(".jpg") || path.endsWith(".png"))) throw new IllegalArgumentException("illegal import file extension")
//  override def checkString(): Unit = {
//    if(!new File(path).exists()) throw new IllegalArgumentException("import image file doesn't exist")
//    if(!(path.endsWith(".jpg") || path.endsWith(".png"))) throw new IllegalArgumentException("illegal import file extension")
//  }

  override def createModule: Creator[RgbImage] = {
    if(path.endsWith(".jpg") || path.endsWith(".png")) new ImageIOLoader(new File(path))
    else ??? //TODO: this is here just for future support of files that can't be handled by imageIO
  }
}
