import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String EncryptedText = args[0];
                //"attackondawn";
               // args[0];

        StringBuilder Key = new StringBuilder(args[1]);
                //new StringBuilder("lemon");
                //args[1]);
        if(Key.length()>EncryptedText.length()) return;
        System.out.println("InitialInput: "+ EncryptedText);
        int a =0;
        while (Key.length()<EncryptedText.length())
        {
            Key.append(Key.charAt(a));
            a++;
        }
        Character[][] VigenereTable = new Character[26][26];
        int y = 0;
        for (int i =0;i<26;i++)
        {
            int u = 97;

            for(int j=0;j<26;j++)
            {
                int b = u+y;
                if(b>122) b = b-26;
                VigenereTable[i][j]=(char) (b);
                u++;
            }
            y++;
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < EncryptedText.length(); i++) {
            result.append(VigenereTable[Key.charAt(i)-97][EncryptedText.charAt(i)-97]);
        }
        System.out.println("Result of encryption: "+result);

        StringBuilder result1= new StringBuilder("");
        //result.delete(0,result.length());
        for (int i = 0; i < Key.length(); i++) { //L

            for (int j = 0; j < 26; j++) {
                if(VigenereTable[Key.charAt(i)-97][j]==EncryptedText.charAt(i)) result1.append((char)(97+j));
            }

        }
        System.out.println("Result of decryption: "+result1);
    }
}
