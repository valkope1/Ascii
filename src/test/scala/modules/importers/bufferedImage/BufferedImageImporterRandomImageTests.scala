package modules.importers.bufferedImage

import org.scalatest.funsuite.AnyFunSuite

class BufferedImageImporterRandomImageTests extends AnyFunSuite{
  test("making random file"){
    val importer = BufferedImageImporterRandomImage()
    val bufferedImage = importer.load()
    assert(bufferedImage.getHeight > 0)
    assert(bufferedImage.getHeight <= 200)
    assert(bufferedImage.getWidth > 0)
    assert(bufferedImage.getWidth <= 200)
  }

}
