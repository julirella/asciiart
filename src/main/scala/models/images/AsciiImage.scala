package models.images

case class AsciiImage(pixels: List[List[Char]]) extends Image[Char] (pixels)
