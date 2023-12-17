package asciiArtApp.creators.loaders

import models.images.RgbImage
import models.pixels.RgbPixel

import java.io.File
import javax.imageio.ImageIO
//  source: https://otfried.org/scala/image.html

class ImageIOLoader(val file: File) extends ImageLoader(file) {
  /**
   * convert a pixel from ImageIO rgb pixel format to RgbPixel
   *
   * @param from integer representing ImageIO rgb pixel
   * @return the converted RgbPixel
   */
  private def intToRgbPixel(from: Int): RgbPixel = {
    val red = (from & 0xff0000) / 65536
    val green = (from & 0xff00) / 256
    val blue = from & 0xff
    new RgbPixel(red, green, blue)
  }

  //https://www.geeksforgeeks.org/multidimensional-arrays-in-scala/

  /**
   * Load an image from file using ImageIO and convert it to RgbImage
   *
   *  @return The created RgbImage
   */
  override def create(): RgbImage = {
      val bufferedImage = ImageIO.read(file)
      val width = bufferedImage.getWidth
      val height = bufferedImage.getHeight
      val pixels: Array[Array[RgbPixel]] = Array.ofDim[RgbPixel](height, width)
      for (h <- 0 until height) {
        for (w <- 0 until width) {
          pixels(h)(w) = intToRgbPixel(bufferedImage.getRGB(w, h))
        }
      }
    new RgbImage(pixels)
  }
}
