/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.*; 
import java.sql.*; 
public class se {
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
    public static class Hash{
    
    public  static HashMap <String,Integer> myHash= new HashMap<String,Integer>();
    public static void go()
    {
        String[] stopwords = {"a", "ac" , "ab" , "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully","b", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by","c", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently","d", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during","e", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except","f", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings","g","h", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead","i", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just","j", "k","keep", "keeps", "kept", "know", "knows", "known","l", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd","m", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself","n", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere","o", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own","p", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides","q", "que", "quite", "qv","r", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right","s", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure","t", "to", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "u", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "v", "value", "various", "very", "via", "viz", "vs", "w", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "www", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt","x","y", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "z", "zero"};
        for( String s : stopwords )
        {
            myHash.put(s,1);
        }
    }
}
    static Hash hash_obj= new Hash();
    public static void main(String args[])
    {
    hash_obj.go();
    String myQuery;
    Scanner sc= new Scanner(System.in);
    myQuery=sc.nextLine();
    String[] keyWords=myQuery.split("\\s+");
    ArrayList <String> result=new ArrayList <String>();
    try
	{
    Class.forName("com.mysql.cj.jdbc.Driver");    
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
	ArrayList<String> list = new ArrayList<String>(); 
    for( String s : keyWords )
    {
            ArrayList<String> temp=new ArrayList();
            boolean bin = hash_obj.myHash.containsKey(s);
            if(!bin)
            {
                try{
                    Statement stmt=con.createStatement();
                    String query="select link,count from indexed where keyword='"+s+"'";
                    ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) 
                            {
                            String l = rs.getString("link");
                            int count = rs.getInt("count");
                            System.out.println(l+" "+count);
                            if(temp.contains(l));
                            else
                            {
                                temp.add(l);
                                list.add(l);
                            }
                            }
                    }
                catch(SQLException e)
                    {
                    }
            }
    }
	Set<String> st = new HashSet<String>(list);
	ArrayList<obj> arr = new ArrayList<obj>();
	for (String s1 : st) 
		arr.add(new obj(s1,Collections.frequency(list, s1)));
	Collections.sort(arr,obj.comparator);
	for(obj o: arr)
        {
			result.add(o.str);
                        System.out.println(o.str );
	}
        }
	catch(Exception e)
	{
		System.out.println(e);
	}
    }
}
