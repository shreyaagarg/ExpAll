/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import org.jsoup.Jsoup;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 
import java.util.*; 
import java.sql.*;


public class HTMLUtils {
  private HTMLUtils() {}
	public static class obj
		{
			String str;
			int i;
			obj(String str,int i)
			{
				this.str=str;
				this.i=i;
			}
			public static Comparator<obj> comparator = new Comparator<obj>() {

	public int compare(obj o1, obj o2) {
	   return o2.i-o1.i;
    }};
		}
	
	private static Set<String> wordsSet;
	
	public static String[] stopwords = {"a", "ac" , "ab" , "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully","b", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by","c", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently","d", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during","e", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except","f", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings","g","h", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead","i", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just","j", "k","keep", "keeps", "kept", "know", "knows", "known","l", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd","m", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself","n", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere","o", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own","p", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides","q", "que", "quite", "qv","r", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right","s", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure","t", "to", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "u", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "v", "value", "various", "very", "via", "viz", "vs", "w", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "www", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt","x","y", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "z", "zero"};

	private static String tostring(InputStream inputStream) throws IOException
    {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")))
        {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(inputLine);
            }
            return stringBuilder.toString();
        }
    }
	
  public final static void main(String[] args) throws Exception{
	   int count=1;
		FileReader reader = new FileReader("C:\\Users\\HP\\Desktop\\SEM 5\\minor\\New folder (2)\\Database\\links.txt");
		BufferedReader br = new BufferedReader(reader);
		String line;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
		
		while ( (line=br.readLine()) != null) {
		String[] arrOfStr = line.split("[:/\\-._+,?#=&@(0-9)]+"); 
		for (String a : arrOfStr)
		{
		try{
		Statement st=con.createStatement();
		String sm="insert into indexed(keyword,link,count) values('"+a+"','"+line+"',-1)";
		st.executeUpdate(sm); 
		}
		catch(SQLException e)
		{
		}
		}
		try{
		URL urlObject = new URL(line);
        URLConnection urlConnection = urlObject.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        String s= tostring(urlConnection.getInputStream());
		String textOnly = Jsoup.parse(s).text();
		textOnly = textOnly.replaceAll("[^A-Za-z ]", " ");
		String[] words = textOnly.split("\\s+");
		ArrayList<String> list = new ArrayList<String>(); 
		for(int i=0;i<words.length;i++)
		{
			words[i] = words[i].toLowerCase();
			boolean flag=true;
			for(int j=0;j<stopwords.length;j++)
			{
				if(words[i].equals(stopwords[j]))
				{
					flag=false;
					break;
				}
			}
			if(flag==true)
			{
				list.add(words[i]);
			}
		}
		Set<String> st = new HashSet<String>(list);
		ArrayList<obj> arr = new ArrayList<obj>();
		for (String s1 : st) 
			arr.add(new obj(s1,Collections.frequency(list, s1)));
		Collections.sort(arr,obj.comparator);
	    for(obj o: arr)
		{
			if(o.i<=10)
				break;
		try{
		Statement stmt=con.createStatement();
		String smt="insert into indexed(keyword,link,count) values('"+o.str+"','"+line+"',"+o.i+")";
		stmt.executeUpdate(smt); 
		}
		catch(SQLException e)
		{
		}
		}
		System.out.println(count++);
		}
		catch (Exception e)
		{
			System.out.println("Exception in:"+count);
			count++;
		}
		}
		con.close();
  }
}