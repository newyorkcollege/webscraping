package web.scraping;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Retrieves the top 250 IMDB movies and extracts title and rating.
 * Based on "Web Scraping with Java: Scrape IMDB Top 250" by Patrick Meier
 * https://www.youtube.com/watch?v=ZpBWXTa-aIg
 */
public class ImdbScraper {
    
    public static void main(String [] args) {
        
        try {
            Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
            
            for(Element row : document.select("table.chart.full-width tr")) {
                String title = row.select(".titleColumn a").text();
                String rating = row.select(".imdbRating").text();
                if(title.equals("")) {
                    continue;
                }
                System.out.println(title + ", rating: " + rating);
            }
            
        } catch (IOException ex) {
            System.out.println("IO Exception\n" + ex.getMessage());
        }
        
    }
    
}
