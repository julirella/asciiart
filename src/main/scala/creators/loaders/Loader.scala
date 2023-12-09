package creators.loaders

import creators.Creator

import java.io.File

abstract class Loader[T](path: File) extends Creator[T] {
}
