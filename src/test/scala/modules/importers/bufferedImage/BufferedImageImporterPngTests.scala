package modules.importers.bufferedImage

import org.scalatest.funsuite.AnyFunSuite
import org.mockito.Mockito.*

import java.io.File

class BufferedImageImporterPngTests extends AnyFunSuite{
  test("file doesnt exist"){
    var mockFile = mock(classOf[File])
    when(mockFile.exists()).thenReturn(false)
    assertThrows[Exception]{
      BufferedImageImporterPng(mockFile)
    }
  }
}
