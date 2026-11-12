package modules.importers

trait Importer[T] {
  def load(): T

}
