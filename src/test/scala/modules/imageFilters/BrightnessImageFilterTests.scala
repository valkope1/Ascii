package modules.imageFilters

import models.images.GreyImage
import models.pixels.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class BrightnessImageFilterTests extends AnyFunSuite{
  test("normal positive brightness"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = BrightnessImageFilter(50)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 50)
    assert(newGreyImage.getPixel(0, 1).grey == 100)
    assert(newGreyImage.getPixel(1, 0).grey == 150)
    assert(newGreyImage.getPixel(1, 1).grey == 200)
  }
  test("normal negative brightness") {
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = BrightnessImageFilter(-50)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 0)
    assert(newGreyImage.getPixel(0, 1).grey == 0)
    assert(newGreyImage.getPixel(1, 0).grey == 50)
    assert(newGreyImage.getPixel(1, 1).grey == 100)
  }
  test("big positive brightness"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = BrightnessImageFilter(1000)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 255)
    assert(newGreyImage.getPixel(0, 1).grey == 255)
    assert(newGreyImage.getPixel(1, 0).grey == 255)
    assert(newGreyImage.getPixel(1, 1).grey == 255)
  }
  test("big negative brightness"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = BrightnessImageFilter(-1000)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 0)
    assert(newGreyImage.getPixel(0, 1).grey == 0)
    assert(newGreyImage.getPixel(1, 0).grey == 0)
    assert(newGreyImage.getPixel(1, 1).grey == 0)
  }
}
