package models.images
import models.pixels.RgbPixel

import java.awt.image.BufferedImage
case class RgbImage(image : List[List[RgbPixel]]) extends Image {

}
