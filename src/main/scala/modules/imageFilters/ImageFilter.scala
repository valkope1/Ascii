package modules.imageFilters

import models.images.Image



trait ImageFilter[T<: Image]{
  def applyFilter(image: T) : T
  def check(image: Image) : Unit= {
    if(image.height <= 0 || image.width <= 0) {
      throw Exception("invalid image size")
    }
  }
}
