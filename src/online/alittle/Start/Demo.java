package online.alittle.Start;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
	private static File file;

	private static Reader reader;
	private static final int MAX_FRAME = 6568;
	private static final int MAX_LINE;
	private static String[] buffer = new String[MAX_FRAME];
	static {
		MAX_LINE = 35;
	}

	public static void main(String[] args) throws Exception {
		readBuffer("BadApple.dat");
		new MusicPlayer("BadApple.wav").start();
		mainLoop();
		
	}

	private static void readBuffer(String path) {
		try {
			file = new File(path);
			System.out.println(file.getAbsolutePath());
			reader = new Reader(file);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < MAX_FRAME; i++) {
				for (int j = 0; j < MAX_LINE; j++) {
					String str = reader.readLine();
					sb.append(str);
					sb.append('\n');
				}
				buffer[i] = sb.toString();
				sb = new StringBuilder("");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 private static void mainLoop() throws Exception {
		 
		 
		 FileWriter fileWriter = new FileWriter("bad.txt");
		
	        for (int i = 0; i < MAX_FRAME; i++) {
//	            buffer[i];
//	        	fileWriter.write(buffer[i]);
//	        	fileWriter.flush();
	        	System.out.println(buffer[i]);
	            Thread.sleep(30);
	        }
	    }
}
