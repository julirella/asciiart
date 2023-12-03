package exporters

trait Exporter[T] {
  def export(toExport: T): Unit
}
