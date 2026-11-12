package modules.imageFilters

import models.images.GreyImage
import models.pixels.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class InvertImageFilterTests extends AnyFunSuite{
  test("invert"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = InvertImageFilter()
    assert(greyImage.getPixel(0, 0).grey == 0)
    assert(greyImage.getPixel(0, 1).grey == 50)
    assert(greyImage.getPixel(1, 0).grey == 100)
    assert(greyImage.getPixel(1, 1).grey == 150)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 255)
    assert(newGreyImage.getPixel(0, 1).grey == 205)
    assert(newGreyImage.getPixel(1, 0).grey == 155)
    assert(newGreyImage.getPixel(1, 1).grey == 105)
  }

}
