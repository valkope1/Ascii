package modules.tables.nonLinear

class MineTable extends NonLinearConversionTable {
  var help: Array[(Int, Int)] = Array((0, 200), (201, 254), (255, 255))
  var chars: Array[Char] = "IDK".toCharArray
  var characterCount: Int = chars.length
}
