package converters.image
import helpers.TwoDMapper
import models.images.{GreyScaleImage, RgbImage}
import models.pixels.{GreyScalePixel, RgbPixel}

class RgbToGSConverter extends ImageConverter[RgbImage, GreyScaleImage, RgbPixel, GreyScalePixel] with TwoDMapper[RgbPixel, GreyScalePixel]{

  override protected def convertPixel(from: RgbPixel): GreyScalePixel = {
    GreyScalePixel(((0.3 * from.red) + (0.59 * from.green) + (0.11 * from.blue)).round.toInt)
  }

  override def convert(from: RgbImage): GreyScaleImage = {
    GreyScaleImage(map2D(from.getPixels, convertPixel))
  }
}
