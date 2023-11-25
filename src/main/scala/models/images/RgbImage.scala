package models.images
import models.pixels.RgbPixel

import java.awt.image.BufferedImage
case class RgbImage(private val pixels: List[List[RgbPixel]]) extends Image[RgbPixel] (pixels) {

}
