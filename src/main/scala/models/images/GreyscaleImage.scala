package models.images

class GreyscaleImage (private val pixels : List[List[Int]]) extends Image{
  def getPixels = pixels
  override def updateContent[GreyscaleImage](updater: GreyscaleImage => GreyscaleImage): GreyscaleImage = ???
}
