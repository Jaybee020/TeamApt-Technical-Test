import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Main{

    public static void main(String[] args){
        Pattern mtn=Pattern.compile("^(0703|0706|0803|0806|0810|0813|0814|0816|0903|0906|0913|0916|07025|07026|0704)");
        Pattern airtel=Pattern.compile("^(0701|0708|0802|0808|0812|0901|0902|0904|0907|0912)");
        Pattern globacom=Pattern.compile("^(0705|0805|0807|0811|0815|0905|0915)");
        Pattern ninemobile=Pattern.compile("^(0809|0817|0818|0909|0908)");
        Pattern mtel=Pattern.compile("^(0804)");
        int mtnCount = 0;
        int airtelCount = 0;
        int globacomCount = 0;
        int ninemobileCount = 0;
        int mtelCount = 0;

        try {
            File text = new File("PhoneNumbers.txt");
            Scanner textReader = new Scanner(text);
            while (textReader.hasNextLine()) {
                String data = textReader.nextLine();
                Matcher mtnmatcher=mtn.matcher(data);
                Matcher airtelmatcher=airtel.matcher(data);
                Matcher globacommatcher=globacom.matcher(data);
                Matcher ninemobilematcher=ninemobile.matcher(data);
                Matcher mtelmatcher=mtel.matcher(data);
                if(mtnmatcher.find()){
                    mtnCount++;
                }else if(airtelmatcher.find()){
                    airtelCount++;
                }else if(globacommatcher.find()){
                    globacomCount++;
                }else if(ninemobilematcher.find()){
                    ninemobileCount++;
                }else if(mtelmatcher.find()){
                    mtelCount++;
                }

            }
            textReader.close();
            System.out.println("Summary Report");
            System.out.println("Total MTN Numbers: "+ mtnCount);
            System.out.println("Total MTEL Numbers: "+ mtelCount);
            System.out.println("Total Airtel Numbers: "+ airtelCount);
            System.out.println("Total 9Mobile Numbers: "+ ninemobileCount);
            System.out.println("Total Globacom Numbers: "+ globacomCount);
        } catch (FileNotFoundException e) {
            System.out.println("Could not get file");
        }
    }
}