package asciiArtApp.converters.image
import helpers.TwoDMapper
import asciiArtApp.models.images.{GreyScaleImage, RgbImage}
import asciiArtApp.models.pixels.{GreyScalePixel, RgbPixel}

class RgbToGSConverter extends ImageConverter[RgbImage, GreyScaleImage, RgbPixel, GreyScalePixel]{

  /**
   * convert rgb pixel to greyscale pixel using the weighted method
   * @param from the pixel to convert from
   *  @return the new, converted pixel
   */
  override protected def convertPixel(from: RgbPixel): GreyScalePixel = {
    GreyScalePixel(((0.3 * from.red) + (0.59 * from.green) + (0.11 * from.blue)).round.toInt)
  }

  /**
   * convert rgb image to greyscale image
   * @param from The rgb image to convert from
   *  @return The created greyscale image
   */
  override def convert(from: RgbImage): GreyScaleImage = {
    new GreyScaleImage(new TwoDMapper().map2D(from.getPixels, convertPixel))
  }
}
