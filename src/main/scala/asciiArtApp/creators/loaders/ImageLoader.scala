package asciiArtApp.creators.loaders

import creators.loaders.Loader
import asciiArtApp.models.images.RgbImage

import java.io.File

/**
 * Class that loads an image from a file
 * @param file the file to load the image from
 */
abstract class ImageLoader(file: File) extends Loader[RgbImage](file){

}
