package modules.tables.nonLinear

import org.scalatest.funsuite.AnyFunSuite

class MineTableTests extends AnyFunSuite {
  val table = MineTable()
  test("invalid index -1") {
    assertThrows[Exception] {
      table.getChar(-1)
    }
  }
  test("invalid index 260"){
    assertThrows[Exception] {
      table.getChar(256)
    }
  }
  test("valid index 0") {
    assert(table.getChar(0) == 'I')
  }
  test("valid index 100") {
    assert(table.getChar(100) == 'I')
  }
  test("valid index 200") {
    assert(table.getChar(200) == 'I')
  }
  test("valid index 201") {
    assert(table.getChar(201) == 'D')
  }
  test("valid index 220") {
    assert(table.getChar(220) == 'D')
  }
  test("valid index 254") {
    assert(table.getChar(254) == 'D')
  }
  test("valid index 255"){
    assert(table.getChar(255) == 'K')
  }

}
