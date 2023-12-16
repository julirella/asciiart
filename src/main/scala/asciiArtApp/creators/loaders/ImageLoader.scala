package asciiArtApp.creators.loaders

import creators.loaders.Loader
import models.images.RgbImage

import java.io.File

abstract class ImageLoader(path: File) extends Loader[RgbImage](path){

}
