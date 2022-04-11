import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.io.InputStream;


public class Pogoda {
    public static void main(String[] args) throws IOException {
        int num;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                UserSity sity = new UserSity();
                System.out.println("Введите город");
                String name = scanner.nextLine();
                sity.setNameSity(name);
                String userSiti = sity.getNameSity();
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + userSiti + "&appid=0d72269e54bf7322e4fa5333e8b48cc0&units=metric");
                InputStream input = url.openStream();
                byte[] buffer = input.readAllBytes();
                String str = new String(buffer);
               //System.out.println(str);
                JSONObject jsonObj = new JSONObject(str);
                //System.out.println(str);
                System.out.println("Температура: " + jsonObj.get("main" ));


            } catch (IOException  e) {
                System.out.println("Город не найден. Введите корректно название.");
            }
            System.out.println("Перезапустить приложение?");
            System.out.println("1. - Да, 2. - Нет");
            Scanner in = new Scanner(System.in);
            num = in.nextInt();

        } while (num != 2);
        System.out.println("Ты знаешь, где меня искать...");

    }


}


