package models.images

import models.pixels.Pixel

trait Image(){
  require(width > 0 && width <= 1920, Exception("invalid width"))
  require(height > 0 && height <= 1080, Exception("invalid height"))
  def getPixel(x:Int, y:Int): Pixel 
  def width: Int
  def height: Int
}
