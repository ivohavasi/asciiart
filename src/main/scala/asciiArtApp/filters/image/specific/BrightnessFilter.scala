package asciiArtApp.filters.image.specific

import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel

import scala.collection.mutable.ArrayBuffer

/**
 * Specific {@link ImageFilter}, which adds brightness to {@link GreyscaleImage}.
 *
 * @param brightness value to add to image's brightness
 */
class BrightnessFilter(brightness: Int) extends ImageFilter {

  /**
   * Adds brightness to {@link GreyscaleImage}.
   * <p>
   * Note: max brightness value of image is capped at 255, min is 0.
   * </p>
   *
   * @param item {@link GreyscaleImage} to filter
   * @return filtered {@link GreyscaleImage}
   */
  override def filter(item: GreyscaleImage): GreyscaleImage = {
    val data = new ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => {
      var value = pixel.brightness + brightness

      value match {
        case x if x > 255 => value = 255
        case x if x < 0 => value = 0
        case _ => value = value
      }

      data.append(GreyscalePixel(value))
    })

    item.newImage(GreyscaleGrid(item.getWidth(), data.toArray[GreyscalePixel]))
  }
}
