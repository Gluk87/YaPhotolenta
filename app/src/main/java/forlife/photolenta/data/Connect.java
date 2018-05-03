package forlife.photolenta.data;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Connect extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        URL url;
        BufferedReader br;
        try {
            url = new URL("https://cloud-api.yandex.net/v1/disk/public/resources?public_key=https://yadi.sk/d/Y4nUTa153UAzso&path=/"
            );

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error";
        }
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(false);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Content-Type", "application/xml");
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));


            String line;
            final StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return sb.toString(); // получаем данные в формате JSON

        } catch (IOException e) {
            e.printStackTrace();
            return url.toString();
        }
    }
}