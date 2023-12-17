package asciiArtApp.console.arguments.load

import asciiArtApp.console.arguments.Argument
import creators.Creator
import asciiArtApp.models.images.RgbImage

/**
 * Trait representing an argument that specifies where an image should be imported from
 */
trait LoadArgument extends Argument[Creator[RgbImage]] {
}
