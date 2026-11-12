package modules.tables

trait ConversionTable {
  var chars: Array[Char]
  var characterCount: Int
  def getChar(index: Double): Char
}
