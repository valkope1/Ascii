package modules.importers.bufferedImage
import java.awt.image.BufferedImage
import java.util.Random

class BufferedImageImporterRandomImage extends BufferedImageImporter{
  override def load(): BufferedImage = {
    val rand: Random = new Random()

    val width: Int = rand.nextInt(1, 200)
    val height: Int = rand.nextInt(1, 200)
    val image: BufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    for(h <- 0 until height)
      for(w <- 0 until width)
        image.setRGB(w, h, rand.nextInt(0, 8388609))
    image    
  }
}
