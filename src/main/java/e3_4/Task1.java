package e3_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Task1 {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        double sum = 0;
        int count = 0;

        try {
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = br.readLine(); // header
            int ulkoTaloIndex = -1;

            // find column index
            String[] headers = line.split(";");
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals("UlkoTalo")) {
                    ulkoTaloIndex = i;
                    break;
                }
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String date = parts[0]; // assuming first column is date/time
                if (date.startsWith("01.01.2023")) {
                    String num=parts[ulkoTaloIndex].replace(',','.');
                    double temp = Double.parseDouble(num);
                    sum += temp;
                    count++;
                }
                else if (count>0) {break;}
            }
            br.close();
            System.out.println("Average temperature on 2023-01-01: " + (sum / count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

