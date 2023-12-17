package creators.loaders

import creators.Creator

import java.io.File

/**
 * Loads something from a file
 *
 * @param file the file to load from
 */
abstract class Loader[T](file: File) extends Creator[T] {
}
