import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;


public class ejemplorecurso{
	public static boolean isGifFormat(URL url){
		boolean ret = false;
		try {
			URLConnection con = url.openConnection();
			String headerType = con.getContentType();
			String guessType = con.guessContentTypeFromName(url.getFile());
			ret = headerType.endsWith("gif") || guessType.endsWith("gif");
			} catch (IOException ex) {
				System.out.println(ex);
				}
	return ret;
	}
	
	
	public static void main(String[] args) {
		try{
		URL url = new URL("https://media1.tenor.com/images/e5f6f89d824dcf9ae72/tenor.gif");
		if(isGifFormat(url)){
			System.out.println("Es un gif");
		}else{
			System.out.println("No es un gif");
		}
			}catch(IOException ex){
		System.out.println(ex);
			}
		}
	}	
