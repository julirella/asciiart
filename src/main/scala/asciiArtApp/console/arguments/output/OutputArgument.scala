package asciiArtApp.console.arguments.output

import asciiArtApp.console.arguments.Argument
import exporters.string.StringExporter

/**
 * Trait representing an argument that specifies where a string should be exported to
 */
trait OutputArgument extends Argument[StringExporter]{

}
