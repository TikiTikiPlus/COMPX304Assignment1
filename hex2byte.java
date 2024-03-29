import java.io.*;

public class hex2byte {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String str = "";

        // Loop that reads the standard input
        while(input != null) {
            try {
                str += input;
                input = br.readLine();
            }
            catch(Exception e) {}
        }

        char[] strHex = str.toCharArray();  // Converts the string of hex values into an array
        byte[] strBytes = hexToBytes(strHex);   // Converts the hex values into a stream of bytes

        System.out.println(new String(strBytes));

    }

    /**
     * Takes in a stream of hex values and turns it into a stream of byte values
     * @param hexArr
     * @return an array of the stream of bytes
     */
    private static byte[] hexToBytes(char[] hexArr) {
        final String hexChars = "0123456789ABCDEF";

        byte[] bytesArr = new byte[hexArr.length/2];

        // Loop that converts each pair of hex values into one byte value, and adds it to array
        for(int i = 0; i < bytesArr.length; i++) {
            int byteValue = hexChars.indexOf(hexArr[i*2]) + (hexChars.indexOf(hexArr[i*2+1]) << 4);
            bytesArr[i] = (byte)byteValue;
        }
        
        return bytesArr;
    }
}
