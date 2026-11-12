package modules.tables.linear

import modules.tables.ConversionTable

trait LinearConversionTable extends ConversionTable{
  override def getChar(index: Double): Char = {
    if(index > 255 || index < 0)
      throw Exception("invalid index")
    chars((index / (256.0/characterCount)).toInt)
  }
}
