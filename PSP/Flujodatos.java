import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class Flujodatos{
	public static boolean isText(URL url){
	boolean ret = false;
	try {
			URLConnection con = url.openConnection();
			String headerType = con.getContentType();
			String guessType = con.guessContentTypeFromName(url.getFile());
			ret = headerType.endsWith("text/plain") || guessType.endsWith("text/plain");
			} catch (IOException ex) {
				System.out.println(ex);
				}
				return ret;
	}
	
	private static void printContent(URL url) {
		InputStream in;
		char[] cbuf = new char[512];
		int caractersLlegits;
		if(!isText(url)){
		return;
		}
		try {
			in = url.openStream();
			InputStreamReader inr = new InputStreamReader(in);
			caractersLlegits = inr.read(cbuf);
			while(caractersLlegits != -1){
				String str = String.copyValueOf(cbuf, 0, caractersLlegits);
				System.out.print(str);
				Thread.sleep(1000);
			}
			caractersLlegits = inr.read(cbuf);
			System.out.println();
		}catch (IOException | InterruptedException ex ) {
				System.out.println(ex);	
		}
	} 
	
	public static void main(String[] args) {
		try{
			URL url = new URL ("https://www.rfc-editor.org/rfc/rfc8973.txt");
			printContent(url);
			
		}catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
}

