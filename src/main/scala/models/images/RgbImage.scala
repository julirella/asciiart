package models.images
import models.pixels.RgbPixel

case class RgbImage(private val pixels: List[List[RgbPixel]]) extends Image[RgbPixel] (pixels) {

}
