package asciiArtApp.creators.generators.pixel

import creators.generators.RandomGenerator
import asciiArtApp.models.pixels.Pixel

/**
 * Trait for generating a random pixel
 */
trait RandomPixelGenerator[T <: Pixel] extends RandomGenerator[T] {

}
