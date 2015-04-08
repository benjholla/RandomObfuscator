import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * inspired and based on source from: http://stackoverflow.com/questions/15182496/why-does-this-code-print-hello-world
 * @author Ben Holland
 */
public class RandomCharacters {
	
	public static final char START_ASCII = 31; // not included as valid character
	public static final char END_ASCII = 126; // is included as valid character
	
    public static void main (String[] args) throws Exception {
    	
    	Set<String> stringsSet = stringsToFind("So", "fun", ".");
    	int maxSize = getMaxSizeOfByteArrays(stringsSet);
    	findRandomWords(stringsSet, maxSize);
    }

    private static int getModulus(){
    	return (END_ASCII - START_ASCII) + 1;
    }
    
    private static HashSet<String> stringsToFind(String... strings) {
        HashSet<String> stringsToFind = new HashSet<String>();
        for(String word : strings){
        	stringsToFind.add(word);
        }
        return stringsToFind;
    }
    
    private static int getMaxSizeOfByteArrays(Set<String> stringSet){
    	int max = 0;
    	for(String string : stringSet){
    		if(string.length() > max){
    			max = string.length();
    		}
    	}
    	return max;
    }

    private static void findRandomWords(Set<String> stringsSet, int maxLengthOfStrings) {
        char[] chars = new char[maxLengthOfStrings + 1];
        Random rnd = new Random();
        for (long base = 0; base >= 0; base++) { // start at zero and try positive negative increments of 1
            for (int sign = -1; sign <= 1; sign += 2) { // alternate positive negative signs
                long seed = base * sign;
                rnd.setSeed(seed);
                int i;
                for (i = 0; i < chars.length; i++) {
                    int n = rnd.nextInt(getModulus());
                    if (n == 0) break;
                    chars[i] = (char)(START_ASCII + n);
                }
                String s = new String(chars, 0, i);
                if (stringsSet.contains(s)) {
                    System.out.println(s + ": " + seed);
                    stringsSet.remove(s);
                    if(stringsSet.isEmpty()){
                    	return;
                    }
                }
            }
        }
    }

    public static String randomString(int i)
    {
        Random rnd = new Random(i);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int n = rnd.nextInt(getModulus());
            if (n == 0) break;
            sb.append((char)(START_ASCII + n));
        }
        return sb.toString();
    }
}