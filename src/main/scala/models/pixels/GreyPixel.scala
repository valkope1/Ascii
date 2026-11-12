package models.pixels

case class GreyPixel(grey: Int) extends Pixel {
  require(grey >= 0 && grey <= 255, Exception("invalid grey value!"))
}
