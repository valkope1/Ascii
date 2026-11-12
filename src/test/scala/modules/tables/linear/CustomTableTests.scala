package modules.tables.linear

import org.scalatest.funsuite.AnyFunSuite

class CustomTableTests extends AnyFunSuite{
    val customTable = CustomTable("IDK")
    test("valid index 0"){
        assert(customTable.getChar(0) == 'I')
    }
    test("valid index 85"){
        assert(customTable.getChar(85) == 'I')
    }
    test("valid index 86"){
        assert(customTable.getChar(86) == 'D')
    }
    test("valid index 170"){
        assert(customTable.getChar(170) == 'D')
    }
    test("valid index 171"){
        assert(customTable.getChar(171) == 'K')
    }
    test("valid index 255"){
        assert(customTable.getChar(255) == 'K')
    }
    test("invalid index -1"){
        assertThrows[Exception]{
            customTable.getChar(-1)
        }
    }
    test("invalid index 280"){
        assertThrows[Exception]{
            customTable.getChar(280)
        }
    }

}
