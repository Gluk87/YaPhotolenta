package forlife.photolenta.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import forlife.photolenta.R;
import forlife.photolenta.domain.NetworkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        //Проверяем подключение к сети
        if (NetworkManager.isNetworkAvailable(MainActivity.this)) {  //Если сеть активна, переходим на GoActivity
            Intent intent = new Intent(MainActivity.this, GoActivity.class);
            startActivity(intent);
            finish();
        } else {  //если нет сети, показываем NetworkActivity
            Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
            startActivity(intent);
            finish();
        }
    }
}