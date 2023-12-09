package creators.loaders

import models.images.RgbImage
import models.pixels.RgbPixel
import org.scalatest.{BeforeAndAfter, FunSuite, FunSuiteLike}

import java.awt.image.BufferedImage
import java.io.{File, PrintWriter}
import javax.imageio.ImageIO

class ImageIOLoaderTests extends FunSuiteLike with BeforeAndAfter{

  test("onePixel"){
    val red = 40
    val green = 20
    val blue = 100
    val color = (red * 65536) + (green * 256) + blue
    val testImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    testImg.setRGB(0, 0, color)
    val file = new File("tmp.png")
    ImageIO.write(testImg, "png", file)
    val loader = new ImageIOLoader(file)
    val ret = loader.create()
    file.delete()
    assert(ret == RgbImage(List(List(RgbPixel(red, green, blue)))))
  }

  test("bigger image png"){
    val red1 = 2
    val green1 = 2
    val blue1 = 2
    val red2 = 200
    val green2 = 200
    val blue2 = 200

    val testImg = new BufferedImage(3, 2, BufferedImage.TYPE_INT_RGB)
    testImg.setRGB(0, 0, (red1 * 65536) + (green1 * 256) + blue1)
    testImg.setRGB(1, 0, (red1 * 65536) + (green1 * 256) + blue1)
    testImg.setRGB(2, 0, (red1 * 65536) + (green1 * 256) + blue1)
    testImg.setRGB(0, 1, (red2 * 65536) + (green2 * 256) + blue2)
    testImg.setRGB(1, 1, (red2 * 65536) + (green2 * 256) + blue2)
    testImg.setRGB(2, 1, (red2 * 65536) + (green2 * 256) + blue2)

    val expected = RgbImage(List(
      List(RgbPixel(red1, green1, blue1), RgbPixel(red1, green1, blue1), RgbPixel(red1, green1, blue1)),
      List(RgbPixel(red2, green2, blue2), RgbPixel(red2, green2, blue2), RgbPixel(red2, green2, blue2))
    ))

    val file = new File("tmp.png")
    ImageIO.write(testImg, "png", file)
    val loader = new ImageIOLoader(file)
    val ret = loader.create()
    file.delete()

    assert(ret == expected)
  }

  test("invalid image (in valid file)") {
    //TODO:figure out how to break it
    val red1 = 2
    val green1 = 2
    val blue1 = 2
    val red2 = 200
    val green2 = 200
    val blue2 = 200

    val testImg = new BufferedImage(3, 2, BufferedImage.TYPE_INT_RGB)
    testImg.setRGB(0, 0, (red1 * 65536) + (green1 * 256) + blue1)
    testImg.setRGB(2, 0, (red1 * 65536) + (green1 * 256) + blue1)
    testImg.setRGB(0, 1, (red2 * 65536) + (green2 * 256) + blue2)
    testImg.setRGB(1, 1, (red2 * 65536) + (green2 * 256) + blue2)
    testImg.setRGB(2, 1, (red2 * 65536) + (green2 * 256) + blue2)

    val file = new File("tmp.png")
    ImageIO.write(testImg, "png", file)
    val loader = new ImageIOLoader(file)
    val ret = loader.create()
    file.delete()

//    assert(ret.isEmpty)

  }
}


