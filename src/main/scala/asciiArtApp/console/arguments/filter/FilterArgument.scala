package asciiArtApp.console.arguments.filter

import asciiArtApp.console.arguments.Argument
import asciiArtApp.filters.greyScale.GreyscaleFilter

/**
 * Trait representing an argument that specifies which filter should be used
 */
trait FilterArgument extends Argument[GreyscaleFilter]{

}
