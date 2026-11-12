package modules.exporters.image

import models.images.AsciiImage
import models.pixels.AsciiPixel
import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source
import java.io.File
import java.nio.file.Files

class FileImageExporterTests extends AnyFunSuite{
  private val image = AsciiImage(1, 1, Array(Array(AsciiPixel('H'))))

  test("export"){
    val file = new File("testFiles/test.test")
    val exporter = FileAsciiImageExporter(file)
    exporter.write(image)
    val content = Source.fromFile(file).getLines().mkString("\n")

    assert(content == "H")
  }

  test("No file exists"){
    val file = new File("testFiles/nonexistfile.nono")
    file.delete()
    assert(!file.exists())
    FileAsciiImageExporter(file)
    assert(file.exists())
  }

  test("file exists"){
    val file = new File("testFiles/exists1.txt")
    val file2 = new File("testFiles/exists2.txt")
    assert(file.exists())
    file2.delete()
    Files.copy(file.toPath, file2.toPath)
    var content = Source.fromFile(file2).getLines().mkString("\n")
    assert(content.nonEmpty)
    FileAsciiImageExporter(file2)
    content = Source.fromFile(file2).getLines().mkString("\n")
    assert(content.isEmpty)
  }
}
