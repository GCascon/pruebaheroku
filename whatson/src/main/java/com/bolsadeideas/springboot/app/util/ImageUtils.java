package com.bolsadeideas.springboot.app.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static byte[] resizeImage (byte[] originalBytes, int targetWidth, int targetHeight) throws IOException {
		BufferedImage resizedImage= resizeImage(getImageFromBytes(originalBytes),targetWidth,targetHeight);
		return getBytesFromImage(resizedImage);
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}

	private static BufferedImage getImageFromBytes(byte[] imageData) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
		return ImageIO.read(bais);
	}

	private static byte[] getBytesFromImage(BufferedImage originalImage) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}

}
