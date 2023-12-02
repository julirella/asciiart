package creators.loaders
import models.images.RgbImage
import models.pixels.RgbPixel

import java.io.File
import javax.imageio.ImageIO
//  source: https://otfried.org/scala/image.html

class ImageIOLoader(path: File) extends ImageLoader(path) {
  private def intToRgbPixel(from: Int): RgbPixel = {
    val red = (from & 0xff0000) / 65536
    val green = (from & 0xff00) / 256
    val blue = from & 0xff
    RgbPixel(red, green, blue)
  }

  //https://www.geeksforgeeks.org/multidimensional-arrays-in-scala/
  override def create(): Option[RgbImage] = {
    try {
      val bufferedImage = ImageIO.read(path)
      val width = bufferedImage.getWidth
      val height = bufferedImage.getHeight
      val tmpImage: Array[Array[RgbPixel]] = Array.ofDim[RgbPixel](height, width)
      for (h <- 0 until height) {
        for (w <- 0 until width) {
          tmpImage(h)(w) = intToRgbPixel(bufferedImage.getRGB(w, h))
        }
      }
      val arrayOfLists = tmpImage.map(e => e.toList)
      Some(RgbImage(arrayOfLists.toList))
    } catch {
      case _: Throwable => None
    }
  }
}
