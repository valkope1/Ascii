package modules.exporters

trait Exporter[T] {
  def write(item: T): Unit

}
