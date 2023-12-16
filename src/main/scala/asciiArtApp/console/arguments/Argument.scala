package console.arguments

trait Argument[M] {
  def createModule: M
}
