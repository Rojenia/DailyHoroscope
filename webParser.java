import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webParser {
	
	private static int numWeb = 3;
	private static String[][] horoscope = new String[numWeb][12];

	private static void storeHoroscope(String para, int web, int content){
   			horoscope[web][content] = para;
	}
	
	public static void setHTML(String urlToRead, String h, int web, int content) throws Exception {
			Document doc = Jsoup.connect(urlToRead).get();
			Elements paragraphs = doc.select("."+ h);

			for(Element p : paragraphs){
				String source = p.text();
    	   		storeHoroscope(source, web, content);
			}
       }
	
	public static String getHTML(int web, int sign)
	{
		return horoscope[web][sign];
	}
	
	public static int getSize()
	{
		int counter = 0;
		
   		for(int i = 0; i < 3; i++){
   			for(int j = 0; j < 12; j++){
   			    if (horoscope[i][j] != null)
   			        counter ++;
   			}
   		}

		return counter;
	}
}
