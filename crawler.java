package crawler;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class crawler extends DB{
	public static DB db = new DB();
      

	public static void main(String[] args) throws SQLException, IOException {
		db.runSql2("TRUNCATE crawler;");
		processPage("http://www.wiprodigital.com");
	}
 
	public static void processPage(String URL) throws SQLException, IOException{
		//check if the given URL is already in database
		String sql = "select * from crawler where URL = '"+URL+"'";
		ResultSet rs = db.runSql(sql);
		if(rs.next()){
 
		}else{
			
			sql = "INSERT INTO  `crawler`.`crawler` " + "(`URL`) VALUES " + "(?);";
			PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, URL);
			stmt.execute();
 
		
			Document doc = Jsoup.connect("http://www.wiprodigital.com").get();
 
			Elements questions = doc.select("a[href]");
			for(Element link: questions){
                           String s1=link.attr("href");
                        
                                
                            {
                                if(s1.contains("facebook")||(s1.contains("twitter"))||(s1.contains("linkedin")))
                                System.out.println("Do not do anything1");
                                
                                else if((s1.contains(".mp3"))||(s1.contains(".mp4"))||(s1.contains(".mpeg"))||(s1.contains("3gp")))
                                System.out.println("Do not do anything2");
                             
                                else
                                    {	processPage(link.attr("abs:href"));
                                                                          
                                     System.out.println(s1);
                                    }
	
                            }}}}}
                
 

/**
 *
 * @author rahul
 */

