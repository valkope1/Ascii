package modules.bufferedImageConverters

import org.scalatest.funsuite.AnyFunSuite

import java.awt.image.BufferedImage

class ConverterFromBufferedImageToRGBTests extends AnyFunSuite{
  test("test with image 2x2"){
    val converter = ConverterFromBufferedImageToRGBImage()
    var bufferedImage = BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0xFF0000)
    bufferedImage.setRGB(1, 0, 0x00FF00)
    bufferedImage.setRGB(0, 1, 0x0000FF)
    bufferedImage.setRGB(1, 1, 0xFFFFFF)
    var rgbImage = converter.convert(bufferedImage)

    assert(rgbImage.getPixel(0, 0).red == 255)
    assert(rgbImage.getPixel(0, 0).green == 0)
    assert(rgbImage.getPixel(0, 0).blue == 0)

    assert(rgbImage.getPixel(0, 1).red == 0)
    assert(rgbImage.getPixel(0, 1).green == 255)
    assert(rgbImage.getPixel(0, 1).blue == 0)

    assert(rgbImage.getPixel(1, 0).red == 0)
    assert(rgbImage.getPixel(1, 0).green == 0)
    assert(rgbImage.getPixel(1, 0).blue == 255)


    assert(rgbImage.getPixel(1, 1).red == 255)
    assert(rgbImage.getPixel(1, 1).green == 255)
    assert(rgbImage.getPixel(1, 1).blue == 255)

    assert(rgbImage.width == bufferedImage.getWidth)
    assert(rgbImage.height == bufferedImage.getHeight)
  }
}
