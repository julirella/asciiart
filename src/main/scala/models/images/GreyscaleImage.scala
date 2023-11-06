package models.images

class GreyscaleImage(pixels : List[List[Int]]) extends Image[List[List[Int]]]{
  override def updateContent(updater: List[List[Int]] => List[List[Int]]): GreyscaleImage = ???
}
