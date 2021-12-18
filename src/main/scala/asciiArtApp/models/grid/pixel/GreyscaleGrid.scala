package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel

case class GreyscaleGrid(width: Int, grid: Seq[GreyscalePixel]) extends PixelGrid {
  def foreach(func: GreyscalePixel => Unit): Unit =
    grid.foreach(item => {
      val copied = item.copy()
      func(copied)
    })

  override def get(x: Int, y: Int): GreyscalePixel = {
    val pos = width * y + x

    grid(pos).copy()
  }

  override def getGrid: Seq[GreyscalePixel] = grid
}