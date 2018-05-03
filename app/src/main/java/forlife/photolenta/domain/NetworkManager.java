package forlife.photolenta.domain;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Класс по проверке состояния сети
public class NetworkManager {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
