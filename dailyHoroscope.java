public class dailyHoroscope {

	private static void DailyHoroscope() throws Exception{
		String[][] website_horoscope;
		
		String[] signs = {
			"aries",
			"taurus",
			"gemini",
			"cancer",
			"leo",
			"virgo",
			"libra",
			"scorpio",
			"sagittarius",
			"capricorn",
			"aquarius",
			"pisces",
		};
		
		//
		for(int i = 0; i <= 2; i++){
			for(int j = 0; j < 12 ; j++){
				website_horoscope = new String[][]{
						{"https://www.tarot.com/daily-horoscope/"+signs[j],"js-today_interp_copy"},
						{"https://www.astrology.com/horoscope/daily/"+signs[j]+".html", "page-horoscope-text"},
						{"http://www.astrocenter.com/us/horoscope-daily.aspx?When=0&ZSign="+j+"&Af=0","fontdef1"}
					};

				String web = website_horoscope[i][0];
				String content = website_horoscope[i][1];

				webParser.setHTML(web, content,i,j);
				}
		}
	}
	public static void astroSigns() throws Exception{
		if(webParser.getSize() == 0)
			DailyHoroscope();
	}
}
