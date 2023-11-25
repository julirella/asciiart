package models.images

import models.pixels.AsciiPixel

case class AsciiImage(private val pixels: List[List[AsciiPixel]]) extends Image[AsciiPixel] (pixels)
