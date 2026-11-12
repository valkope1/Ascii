package modules.tables.linear

class CustomTable(customChars: String) extends LinearConversionTable {
  var chars: Array[Char] =  customChars.toCharArray
  var characterCount: Int = chars.length
  
}
