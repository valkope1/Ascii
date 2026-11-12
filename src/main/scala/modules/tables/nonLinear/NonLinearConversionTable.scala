package modules.tables.nonLinear

import modules.tables.ConversionTable

trait NonLinearConversionTable extends ConversionTable{
  var help: Array[(Int, Int)]
  override def getChar(index: Double): Char = {
    if(index < 0 || index > 255)
      throw Exception("invalid index")
    for(n <- help.indices)
      if((help(n)._1 <= index) && (help(n)._2 >= index))
        return chars(n)
    chars(0)
    throw Exception("invalid index1")
  }
}
