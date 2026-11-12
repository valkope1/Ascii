package modules.importers.bufferedImage

import org.scalatest.funsuite.AnyFunSuite
import org.mockito.Mockito.*

import java.io.File

class BufferedImageImporterJpgTests extends AnyFunSuite{
  test("file doesnt exist"){
    var mockFile = mock(classOf[File])
    when(mockFile.exists()).thenReturn(false)
    assertThrows[Exception]{
      BufferedImageImporterJpg(mockFile)
    }
  }
}
