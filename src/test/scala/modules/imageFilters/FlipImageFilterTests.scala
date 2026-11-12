package modules.imageFilters

import models.images.GreyImage
import models.pixels.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class FlipImageFilterTests extends AnyFunSuite{
  test("invalid syntax"){
    assertThrows[Exception]{
      FlipImageFilter("")
    }
    assertThrows[Exception] {
      FlipImageFilter(" ")
    }
    assertThrows[Exception] {
      FlipImageFilter("yss")
    }
    assertThrows[Exception] {
      FlipImageFilter("xx")
    }
  }

  test("flip x"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = FlipImageFilter("x")
    assert(greyImage.getPixel(0, 0).grey == 0)
    assert(greyImage.getPixel(0, 1).grey == 50)
    assert(greyImage.getPixel(1, 0).grey == 100)
    assert(greyImage.getPixel(1, 1).grey == 150)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 50)
    assert(newGreyImage.getPixel(0, 1).grey == 0)
    assert(newGreyImage.getPixel(1, 0).grey == 150)
    assert(newGreyImage.getPixel(1, 1).grey == 100)
  }

  test("flip y"){
    var greyImage = GreyImage(2, 2, Array(Array(GreyPixel(0), GreyPixel(50)), Array(GreyPixel(100), GreyPixel(150))))
    var filter = FlipImageFilter("y")
    assert(greyImage.getPixel(0, 0).grey == 0)
    assert(greyImage.getPixel(0, 1).grey == 50)
    assert(greyImage.getPixel(1, 0).grey == 100)
    assert(greyImage.getPixel(1, 1).grey == 150)
    var newGreyImage = filter.applyFilter(greyImage)
    assert(newGreyImage.getPixel(0, 0).grey == 100)
    assert(newGreyImage.getPixel(0, 1).grey == 150)
    assert(newGreyImage.getPixel(1, 0).grey == 0)
    assert(newGreyImage.getPixel(1, 1).grey == 50)
  }

  

}
