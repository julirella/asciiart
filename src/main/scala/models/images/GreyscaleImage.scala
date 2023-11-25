package models.images

case class GreyscaleImage (private val pixels : List[List[Int]]) extends Image[Int] (pixels){
//  override def updateContent[GreyscaleImage](updater: GreyscaleImage => GreyscaleImage): GreyscaleImage = ???
}
