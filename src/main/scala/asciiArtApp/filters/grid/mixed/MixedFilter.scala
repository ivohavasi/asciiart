package asciiArtApp.filters.grid.mixed

import asciiArtApp.filters.grid.ImageFilter
import asciiArtApp.models.image.grid.GreyscaleImage

/**
 * Mixed {@link ImageFilter}, which applies multiple filters on single {@link GreyscaleImage}.
 *
 * @param filters sequence of filters
 */
class MixedFilter(filters: Seq[ImageFilter]) extends ImageFilter {
  /**
   * Applies all filters on {@link GreyscaleImage}.
   * @param item {@link GreyscaleImage} to apply filters to
   * @return filtered {@link GreyscaleImage}
   */
  override def filter(item: GreyscaleImage): GreyscaleImage =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
