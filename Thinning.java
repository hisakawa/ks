/* 
   --画像処理演習課題--
   所属:
   学籍番号:
   氏名:
*/
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Thinning {

	public static void main(String args[]){
		try{

			/* 入力画像の読み込み */
			BufferedImage readImage = ImageIO.read(new File(args[0])); //第一引数をファイル名とする
			int w = readImage.getWidth(); //横幅
			int h = readImage.getHeight(); //縦幅

			/* 出力画像の準備 */
			BufferedImage writeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		    /*
		     * 細線化処理を記述してください。
		     * 必要に応じて変数・メソッドの定義を行ってかまいません。
		     * 例として下記にコピーを行うだけのメソッドを記述します。
		     */
		    /* 例:コピーを行う処理 */
		    copy(readImage, writeImage, w,h);

		    zhang_suen(writeImage, writeImage, w,h);

		    /* output.pngへの書き込み */
		    ImageIO.write(writeImage, "png", new File("output.png"));

		}catch (IOException e){
			/* 例外処理 */
			throw new RuntimeException(e.toString());
		}
		System.out.println("画像処理が完了しました");
	}

	/*
	 * メソッドの定義
	 */
	/* コピーメソッド */
	public static void copy(BufferedImage readImage, BufferedImage writeImage, int w, int h){

	    int tv = 200;
		// 1ピクセルづつ処理を行う
		for (int y = 0; y < h; y++) {
		    for (int x = 0; x < w; x++) {
				int color = readImage.getRGB(x, y); // 入力画像の画素値を取得


				// 色をr,g,bに分解
   				int r = ( color >> 16 ) & 0xff;
    				int g = ( color >> 8 ) & 0xff;
    				int b = color & 0xff;
    
    				// rgbの平均値を計算
    				int p = ( r + g + b ) / 3;

				// ２値化
    				if ( tv <= p ) {
    					// 閾値tv以上なら白
    					r = 255;
    					g = 255;
    					b = 255;
    				}
    				else {
    					// 閾値tv未満なら黒
    					r = 0;
    					g = 0;
    					b = 0;
    				}
    
    				// r,g,bの色を合成
    				int newcolor = ( r << 16 ) + ( g << 8 ) + b;




				
				writeImage.setRGB(x, y, newcolor); //出力画像に画素値をセット			
		    }
		}
	}

    public static void zhang_suen(BufferedImage readImage, BufferedImage writeImage, int w, int h) {
	    int p2=0,p3,p4,p5,p6,p7,p8,p9;
	    int flag[][]  = new int[h][w];
	    for (int y = 0; y < h; y++) {
		for (int x = 0; x < w; x++) {
		    if (y == 0) {
			p9 = 0;
			p2 = 0;
			p3 = 0;
			if (x == 0) {
			    p8 = 0;
			    p7 = 0;
			} else {
			    p8 = readImage.getRGB(x - 1, y);
			    p7 = readImage.getRGB(x - 1, y + 1);
			}
			if (x == w - 1) {
			    p4 = 0;
			    p5 = 0;
			} else {
			    p4 = readImage.getRGB(x + 1, y);
			    p5 = readImage.getRGB(x + 1, y + 1);
			}
			p6 = readImage.getRGB(x, y + 1);
		    }
		    
		    else if (x == 0) {
			p8 = 0;
			p7 = 0;
			p9 = 0;
			p2 = readImage.getRGB(x, y - 1);
			p3 = readImage.getRGB(x + 1, y - 1);

			if ( y == h - 1) {
			    p6 = 0;
			    p5 = 0;
			} else {
			    p6 = readImage.getRGB(x, y + 1);
			    p5 = readImage.getRGB(x + 1, y + 1);
			}
			p4 = readImage.getRGB(x + 1, y);	
		    }

		    else if (y == h - 1) {
			p7 = 0;
			p6 = 0;
			p5 = 0;
			p8 = readImage.getRGB(x - 1, y);
			p9 = readImage.getRGB(x - 1, y - 1);
			if (x == w - 1) {
			    p3 = 0;
			    p4 = 0;
			} else {
			    p4 = readImage.getRGB(x + 1, y);
			    p3 = readImage.getRGB(x + 1, y - 1);
			}
			p2 = readImage.getRGB(x, y - 1);
		    }

		    else if (x == w - 1) {
			p3 = 0;
			p4 = 0;
			p5 = 0;
			p2 = readImage.getRGB(x, y - 1);
			p9 = readImage.getRGB(x - 1, y - 1);
			p6 = readImage.getRGB(x, y + 1);
			p7 = readImage.getRGB(x - 1, y + 1 );
			p8 = readImage.getRGB(x - 1, y);
		    }
		    
		    else {
			 p2 = readImage.getRGB(x, y - 1);
			 p3 = readImage.getRGB(x + 1, y - 1);
			 p4 = readImage.getRGB(x + 1, y);
			 p5 = readImage.getRGB(x + 1, y + 1);
			 p6 = readImage.getRGB(x, y + 1);
			 p7 = readImage.getRGB(x - 1, y + 1);
			 p8 = readImage.getRGB(x - 1, y);
			 p9 = readImage.getRGB(x - 1, y - 1);
		    }

		    if (x==1 && y==1){
			System.out.println(p2 +""+ p3 + p4 + p5 + p6 + p7 + p8 + p9);
			}
		    if (p2 == -1) p2 = 1;
		    else p2 = 0;
		    if (p3 == -1) p3 = 1;
		    else p3 = 0;
		    if (p4 == -1) p4 = 1;
		    else p4 = 0;
		    if (p5 == -1) p5 = 1;
		    else p5 = 0;
		    if (p6 == -1) p6 = 1;
		    else p6 = 0;
		    if (p7 == -1) p7 = 1;
		    else p7 = 0;
		    if (p8 == -1) p8 = 1;
		    else p8 = 0;
		    if (p9 == -1) p9 = 1;
		    else p9 = 0;
			
		    int count = 0;
		    int a = 0;
		    if (p2 < p3){a++;}
		    if (p3 < p4){a++;}
                    if (p4 < p5){a++;}
                    if (p5 < p6){a++;}
                    if (p6 < p7){a++;}
                    if (p7 < p8){a++;}
                    if (p8 < p9){a++;}
                    if (p9 < p2){a++;}

		    if (a == 1) count++;
		    
                    int b = (p2+p3+p4+p5+p6+p7+p8+p9);
		    if ( 2 <= b && b <= 6) count++;

		    if (p2*p4*p6 == 0 && p4*p6*p8 == 0) count++;
		    else if (p2*p4*p8 == 0 && p2*p6*p8 == 0) count++;

		    //aaaaaaaa
		    /*if (x==2 && y==2){
			System.out.println(p2 +""+ p3 + p4 + p5 + p6 + p7 + p8 + p9);
			}*/
		    

		    //int r = 0, g = 0, v = 0;
		    //int newcolor = ( r << 16 ) + ( g << 8 ) + v;
		    
		    if(count == 3) readImage.setRGB(x, y, 0);    //flag[y][x] = 1;

		    if (x==1 && y==1){
			System.out.println(p2 +""+ p3 + p4 + p5 + p6 + p7 + p8 + p9);
			System.out.println(readImage.getRGB(x,y));
		    }
		}
	    }

	    //for (int y = 0; y < h; y++) {
	    //for (int x = 0; x < w; x++) {
	    //if (flag[y][x] == 1) writeImage.setRGB(x, y, 0);
	    //}
	    //}
	    /*for (int y = 0; y < h; y++) {
		for (int x = 0; x < w; x++) {
		    writeImage.setRGB(x, y, readImage.getRGB(x,y));
		}
		}*/

	    System.out.println(p2);
	}
}
