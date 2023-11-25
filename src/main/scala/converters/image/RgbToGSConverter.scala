package converters.image
import helpers.TwoDMapper
import models.images.{GreyscaleImage, RgbImage}
import models.pixels.RgbPixel

class RgbToGSConverter extends ImageConverter[RgbImage, GreyscaleImage, RgbPixel, Int] with TwoDMapper[RgbPixel, Int]{

//  source: https://otfried.org/scala/image.html
  private def convertPixel(color: RgbPixel): Int = {

    val red = (color.red & 0xff0000) / 65536
    val green = (color.green & 0xff00) / 256
    val blue = color.blue & 0xff

    ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt
  }

  override def convert(from: RgbImage): GreyscaleImage = {
    GreyscaleImage(map2D(from.getPixels, convertPixel))
//    val buffImg = from.image
//    val height = buffImg.getHeight()
//    val width = buffImg.getWidth()
//    var image = List[List[Int]]()
//    for(i <- 0 until height){
//      var row = List[Int]()
//      for(j <- 0 until width){
//        row = row.appended(convertPixel(buffImg.getRGB(i, j)))
//      }
//      image = image.appended(row)
//    }
//    new GreyscaleImage(image)
  }
}
