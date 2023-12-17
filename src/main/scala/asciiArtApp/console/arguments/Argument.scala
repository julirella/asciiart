package asciiArtApp.console.arguments

/**
 * Trait representing an argument ('--' followed by something).
 * Inheriting classes should assure that the argument is valid and produce a module based on it.
 */
trait Argument[M] {
  /**
   * Creates a module of type M based on the type of argument
   * @return the created module
   */
  def createModule: M
}
