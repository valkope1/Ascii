package modules.exporters.image
import models.images.AsciiImage

import java.io.OutputStream


class StreamAsciiImageExporter(outputStream: OutputStream) extends AsciiImageExporter {
  private var closed = false
  
  override def write(item: AsciiImage): Unit = {
    if (closed)
      throw new Exception("stream is closed")
    
    var chars: String = ""
    for(n <- 0 until item.height)
      for(m <- 0 until item.width)
        chars += item.getPixel(n, m).symbol
      chars += "\n"  
    outputStream.write(chars.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return
    outputStream.close()
    closed = true
  }


}
