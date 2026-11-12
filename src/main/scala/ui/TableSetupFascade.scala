package ui

import modules.tables.ConversionTable
import modules.tables.linear.PaulBourkesTable
import modules.tables.nonLinear.MineTable

class TableSetupFascade() {
  def setupTable(str: String): ConversionTable= {
    str match
      case "MineTable" =>
        MineTable()
      case "PaulBourkesTable" =>
        PaulBourkesTable()
      case _ => throw Exception("invalid table name")
  }
}
