package demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;


public class Main {

	public static void main(String[] args) {
		
		
		//File1 is file bitmap has size 100x100, File2 is file png has size 100x100
		File file1 = null;
		BufferedImage imgBitmapSelected = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		File file2 = null;
		BufferedImage imgPngSelected = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				int alpha = 255;
				int red = 0;
				int green = 0;
				int blue = 255;
				
				int pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
				imgBitmapSelected.setRGB(j, i, pixel);
				imgPngSelected.setRGB(j, i, pixel);
			}
		}
		
		try {
			file1 = new File("D:/TOPICA/anhbai3_bmp100x100.bmp");
			ImageIO.write(imgBitmapSelected, "bmp", file1);
			
			file2 = new File("D:/TOPICA/anhbai3_png100x100.png");
			ImageIO.write(imgPngSelected, "png", file2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//File3 is file bitmap has size 10000x10000, File2 is file png has size 10000x10000
				File file3 = null;
				BufferedImage imgBitmapSelected2 = new BufferedImage(10000, 10000, BufferedImage.TYPE_INT_RGB);
				
				File file4 = null;
				BufferedImage imgPngSelected2 = new BufferedImage(10000, 10000, BufferedImage.TYPE_INT_RGB);
				
				for(int i = 0; i < 10000; i++) {
					for(int j = 0; j < 10000; j++) {
						int alpha = 255;
						int red = 0;
						int green = 0;
						int blue = 255;
						
						int pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
						imgBitmapSelected2.setRGB(j, i, pixel);
						imgPngSelected2.setRGB(j, i, pixel);
					}
				}
				
				try {
					file3 = new File("D:/TOPICA/anhbai3_bmp10000x10000.bmp");
					ImageIO.write(imgBitmapSelected2, "bmp", file3);
					
					file4 = new File("D:/TOPICA/anhbai3_png10000x10000.png");
					ImageIO.write(imgPngSelected2, "png", file4);
				}catch(IOException e) {
					e.printStackTrace();
				}
	}
	
}
