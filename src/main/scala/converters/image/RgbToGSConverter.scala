package converters.image
import models.images.{GreyscaleImage, Image, RgbImage}

class RgbToGSConverter extends ImageConverter[RgbImage, GreyscaleImage] {

//  source: https://otfried.org/scala/image.html
  private def convertPixel(color: Int): Int = {
    val red = (color & 0xff0000) / 65536
    val green = (color & 0xff00) / 256
    val blue = (color & 0xff)

    ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt
  }

  //make functional
  override def convert(from: RgbImage): GreyscaleImage = {
    val buffImg = from.image
    val height = buffImg.getHeight()
    val width = buffImg.getWidth()
    var image = List[List[Int]]()
    for(i <- 0 until height){
      var row = List[Int]()
      for(j <- 0 until width){
        row = row.appended(convertPixel(buffImg.getRGB(i, j)))
      }
      image = image.appended(row)
    }
    new GreyscaleImage(image)
  }
}
