package demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChangeColorImage {
	public static void main(String[] args) {
		
		//READ FILE
		BufferedImage imgSelected = null;
		File file = null;
		try {
			file = new File("D:/TOPICA/anhthuchanh.jpg");
			imgSelected = ImageIO.read(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//Get width matrix of imgSelected
		int width = imgSelected.getWidth();
		
		//Get height matrix of imgSelected
		int height = imgSelected.getHeight();
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x <  width; x++) {
				int pixel = imgSelected.getRGB(x, y);
				
				//Get alpha, red, green, blue of pixel
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = pixel & 0xff;
				
				//Change color red: change pixel of red: (0->255,0,0) to pixel of green: (0,255,0)
				/*if((red != 0)&&(green == 0)&&(blue == 0)) {
					red = 0;
					green = 255;
					blue = 0;
				}
				pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
				imgSelected.setRGB(x, y, pixel);
				try {
					file = new File ("D:/TOPICA/anhthuchanh_output1.jpg");
					ImageIO.write(imgSelected, "jpg", file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				*/
				
				if(((120 <= red)&&(green <= 50)&&(blue <= 50)&&(180 >= red)) || ((red < 120)&&(green <= 30)&&(blue <= 30)&&(red >= 80)) ||(red > 180)&&(green <= 100)&&(blue <= 100)) {
					red = 0;
					green = 255;
					blue = 0;
					pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
				}else {
					pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
				}
				imgSelected.setRGB(x, y, pixel);
			}
		}
		
		//WRITE FILE
		try {
			file = new File ("D:/TOPICA/anhthuchanh_output.jpg");
			ImageIO.write(imgSelected, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
