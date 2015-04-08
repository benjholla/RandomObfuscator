import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// based on original source from: http://stackoverflow.com/questions/15182496/why-does-this-code-print-hello-world
public class RandomWords {
	
    public static void main (String[] args) {

    }

    private static HashSet<String> stringsToFind(String... strings) {
        HashSet<String> stringsToFind = new HashSet<String>();
        for(String string : strings){
        	stringsToFind.add(string);
        }
        return stringsToFind;
    }

    private static void findRandomStrings(Set<String> stringSet) {
        char[] c = new char[256];
        Random r = new Random();
        for (long base = 0; base >= 0; base++) { // start at zero and try positive negative increments of 1
            for (int sign = -1; sign <= 1; sign += 2) { // alternate postive negative signs
                long seed = base * sign;
                r.setSeed(seed);
                int i;
                for (i = 0; i < c.length; i++) {
                    int n = r.nextInt(27);
                    if (n == 0) break;
                    c[i] = (char)((int)'a' + n - 1);
                }
                String s = new String(c, 0, i);
                if (stringSet.contains(s)) {
                    System.out.println(s + ": " + seed);
                    stringSet.remove(s);
                }
            }
        }
    }
    
    public static String randomString(int i)
    {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
            sb.append((char)('`' + k));
        }
        return sb.toString();
    }
}