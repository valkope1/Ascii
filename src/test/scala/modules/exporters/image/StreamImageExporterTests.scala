package modules.exporters.image

import models.images.{AsciiImage, GreyImage, RGBImage}
import models.pixels.{AsciiPixel, GreyPixel, RGBPixel}
import org.scalatest.funsuite.AnyFunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class StreamImageExporterTests extends AnyFunSuite(){
  test("AsciiImage only with 1 symbol") {
    val output = new ByteArrayOutputStream()
    val exporter = StreamAsciiImageExporter(output)
    val image1 = AsciiImage(1, 1, Array(Array(AsciiPixel('H'))))
    exporter.write(image1)
    assert(output.toString == "H\n")
  }
}
