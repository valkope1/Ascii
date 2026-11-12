package modules.tables.linear

import org.scalatest.funsuite.AnyFunSuite

class PaulBourkesTableTests extends AnyFunSuite{
  val table = PaulBourkesTable()
  test("invalid index -1 ") {
    assertThrows[Exception] {
      table.getChar(-1)
    }
  }
  test("invalid index 280") {
    assertThrows[Exception] {
      table.getChar(280)
    }
  }
  test("valid index 0") {
    assert(table.getChar(0) == '$')
  }
  test("valid index 255") {
    assert(table.getChar(255) == ' ')
  }
  test("valid index 128"){
    assert(table.getChar(128) == 'x')
  }

}
