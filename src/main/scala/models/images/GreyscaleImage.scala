package models.images

class GreyscaleImage(pixels : List[List[Int]]) extends Image{
  override def updateContent[GreyscaleImage](updater: GreyscaleImage => GreyscaleImage): GreyscaleImage = ???
}
