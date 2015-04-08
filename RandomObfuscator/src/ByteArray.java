import java.util.Arrays;


public class ByteArray {

	private byte[] byteArray;
	
	public ByteArray(byte[] bytes, int length){
		this.byteArray = new byte[length];
		for(int i=0; i<length; i++){
			this.byteArray[i] = bytes[i];
		}
	}
	
	public ByteArray(byte[] bytes){
		this.byteArray = new byte[bytes.length];
		for(int i=0; i<bytes.length; i++){
			this.byteArray[i] = bytes[i];
		}
	}
	
	public byte[] getByteArray(){
		return byteArray;
	}
	
	private String byteToHexString(byte b) {
		return "0x" + String.format("%02x", b).toUpperCase();
	}
	
	private String byteToIntString(byte b) {
		return "" + ((int)b);
	}
	
	@Override
	public String toString(){
		String result = "{";
		for(int i=0; i<byteArray.length; i++){
			result += byteToIntString(byteArray[i]) + ", ";
		}
		result = result.substring(0, result.lastIndexOf(", "));
		return result + "}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(byteArray);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ByteArray other = (ByteArray) obj;
		if (!Arrays.equals(byteArray, other.byteArray))
			return false;
		return true;
	}
	
}
