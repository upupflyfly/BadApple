package online.alittle.Start;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author 东哥 2016年10月27日
 *
 * 
 * 
 *         /**
 * @param path
 *            图片路径
 */
public class AsciiPic {
	public static void createAsciiPic(final String path) {
		final String base = "102#";// 字符串由复杂到简单
//		final String base = "@#&$%*o!;.";// 字符串由复杂到简单
		try {
			final BufferedImage image = ImageIO.read(new File(path));
			for (int y = 0; y < image.getHeight(); y += 6) {
				for (int x = 0; x < image.getWidth(); x += 5) {
					final int pixel = image.getRGB(x, y);
					final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
					final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
					final int index = Math.round(gray * (base.length() + 1) / 255);
					System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
				}
				System.out.println();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * test
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		AsciiPic.createAsciiPic("timg.jpg");
	}
}
