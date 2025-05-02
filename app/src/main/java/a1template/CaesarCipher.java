// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import javax.management.openmbean.InvalidKeyException;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char)('a' + i);
        }
        this.offset = offset;
        this.cipher = new DynamicArray<Character>(offset, alphabet);
    }

    /** Implementation of linear search that looks through the alphabet
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(Character val) {
        if (!Character.isLowerCase(val)) {
            Character.toLowerCase(val);
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        throw new InvalidKeyException("ERROR: character not found");
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                char thisChar = Character.toLowerCase(charArray[i]);
                int index = findIndex(thisChar);
                charArray[i] = get(index);
            }  else {
                charArray[i] = charArray[i];
            }
        }
        String str = new String(charArray);
        System.out.println(str);
        return str;
    }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message){
        char[] charArray = message.toCharArray();
        for (int n = 0; n < charArray.length; n++) {
            if (Character.isLetter(charArray[n])) {
                char thisChar = Character.toLowerCase(charArray[n]);
                int i = findIndex(thisChar);
                charArray[n] = cipher.get(i, offset);
            }
        }
        String str = new String(charArray);
        return str;
    }

    /**
     * Getter for a certain index
     * @param index accessor
     * @return character at that index
     */
    public char get(int index) {
        int adjustedI = index - offset;
        if (adjustedI < 0) {
            return alphabet[alphabet.length + adjustedI];
        } else if (adjustedI >= alphabet.length){
            return alphabet[adjustedI - alphabet.length];
        } else {
            return alphabet[adjustedI];
        } 
    }

    

    public static void main(String[] args) {
        CaesarCipher testCipher = new CaesarCipher(25);
        String encodedMessage = testCipher.encode("computer science");
        System.out.println(encodedMessage);

    }
    
}
