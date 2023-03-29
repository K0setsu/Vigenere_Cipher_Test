import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) throws IOException {
        boolean again = true;

        String key = "CLANG"; //key
        do {
        Scanner toDo = new Scanner(System.in);
        System.out.println("Encrypt new/Decrypt old?");
        String doing = toDo.nextLine();



    switch (doing) {
        case ("Encrypt"):
            Scanner text = new Scanner(System.in);
            System.out.println("Type the messege in:");
            String originalMessege = text.nextLine();
            File file = new File("OriginalText.txt");
            File cryptedFile = new File("Crypt.txt");
            FileWriter pw = new FileWriter(file);
            pw.write(originalMessege);
            pw.close();

            String messege = originalMessege;
            String encryptedMessege = encrypt(messege, key); //encrypting and saving
            FileWriter crypto = new FileWriter(cryptedFile);
            crypto.write(encryptedMessege);
            crypto.close();

            Scanner write_out = new Scanner(cryptedFile); //messege out
            while (write_out.hasNextLine())
                System.out.println(write_out.nextLine());
            break;
        case ("Decrypt"):
            File crypted = new File("Crypt.txt");
            String messegeFromFile = new String(Files.readAllBytes(Paths.get("Crypt.txt")));
            String decypher = Decrypt(messegeFromFile, key);
            System.out.println(messegeFromFile);
            System.out.println("Original messege is:" + decypher);
            break;
        case ("Exit") : System.exit(0);
        break;
        default:
            System.out.println("try again");
            again = false;
            break;
    }
}while(again = true);

        }

//encryption
        public static String encrypt (String text, final String key){
    String res = " ";
    text = text.toUpperCase();
    for (int i = 0, j = 0; i<text.length(); i++){
char c = text.charAt(i);
if(c<'A'||c>'Z')
    continue;
res +=  (char) ((c + key.charAt(j)-2*'A')%26+'A');
j = ++j % key.length();
            }
return res;

        }
    public static String Decrypt(String text, final String key){
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if (c<'A'||c>'Z')
                continue;
            res += (char) ((c-key.charAt(j)+26)%26+'A');
            j=++j%key.length();
        }
        return res;
    }

}
