import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Ben Holland
 * Inspired by http://stackoverflow.com/questions/15182496/why-does-this-code-print-hello-world
 */
public class RandomBytes {
	
	 public static void main (String[] args) {
		 
		    byte[] b = "a".getBytes();
		    
		    System.out.println(randomByteArray(findSeedForByteArray(new ByteArray(b))));
		    
		    /*
	    	Set<ByteArray> byteArraySet = byteArraysToFind(b);
	    	
	        System.out.println("Searching: " + byteArraySet.size() + " byte arrays.");
	        
	        findRandomByteArrays(byteArraySet, getMaxSizeOfByteArrays(byteArraySet));
	        
	        System.out.println("Done.\n");
	        
	        System.out.println(randomByteArray(-9223372036847391542L));
	        */
	    }

	    private static HashSet<ByteArray> byteArraysToFind(byte[]... byteArrays) {
	        HashSet<ByteArray> bytesArraysToFind = new HashSet<ByteArray>();
	        for(byte[] byteArray : byteArrays){
	        	bytesArraysToFind.add(new ByteArray(byteArray));
	        }
	        return bytesArraysToFind;
	    }
	    
	    private static int getMaxSizeOfByteArrays(Set<ByteArray> byteArraySet){
	    	int max = 0;
	    	for(ByteArray byteArray : byteArraySet){
	    		if(byteArray.getByteArray().length > max){
	    			max = byteArray.getByteArray().length;
	    		}
	    	}
	    	return max;
	    }

	    private static void findRandomByteArrays(Set<ByteArray> byteArraySet, int maxLengthOfByteArray) {
	        byte[] bytes = new byte[maxLengthOfByteArray];
	        Random rnd = new Random();
	        for (long seed = Long.MIN_VALUE; seed <= Long.MAX_VALUE; seed++) {
	            rnd.setSeed(seed);
	            int i;
	            for(i=0; i<bytes.length; i++){
	            	int n = rnd.nextInt(257);
	            	if (n==256) break;
	            	bytes[i] = (byte)(n & 0xFF);
	            }
	            ByteArray byteArray = new ByteArray(bytes, i);
	            if(byteArraySet.contains(byteArray)){
	            	System.out.println(byteArray.toString() + " : " + seed);
	            	byteArraySet.remove(byteArray);
	            	if(byteArraySet.isEmpty()){
	            		return;
	            	}
	            }
	        }
	    }
	    
	    private static long findSeedForByteArray(ByteArray byteArray) {
	        byte[] bytes = new byte[byteArray.getByteArray().length+1];
	        Random rnd = new Random();
	        for (long seed = Long.MIN_VALUE; seed <= Long.MAX_VALUE; seed++) {
	            rnd.setSeed(seed);
	            int i;
	            for(i=0; i<bytes.length; i++){
	            	int n = rnd.nextInt(257);
	            	if (n==256) break;
	            	bytes[i] = (byte)(n & 0xFF);
	            }
	            ByteArray test = new ByteArray(bytes);
	            if(byteArray.equals(test)){
	            	System.out.println("Seed = " + seed);
	            	return seed;
	            }
	        }
	        throw new RuntimeException("Could not find seed for " + byteArray.toString() + "!");
	    }
	    
	    public static String randomByteArray(long seed)
	    {
	    	byte[] bytes = new byte[256];
	        Random rnd = new Random();
	        rnd.setSeed(seed);
            int i;
            for(i=0; i<bytes.length; i++){
            	int n = rnd.nextInt(257);
            	if (n==256) break;
            	bytes[i] = (byte)(n & 0xFF);
            }
            ByteArray byteArray = new ByteArray(bytes, i);
            return byteArray.toString();
	    }
	    
}
