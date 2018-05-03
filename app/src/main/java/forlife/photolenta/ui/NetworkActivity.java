package forlife.photolenta.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import forlife.photolenta.R;
import forlife.photolenta.domain.NetworkManager;

//Если нет сети, показываем данную активность.
// Из данной активности можно перейти на основную при нажатии кнопки,
// если пользователь включил сеть.
public class NetworkActivity extends Activity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        textView = findViewById(R.id.textView3);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkManager.isNetworkAvailable(NetworkActivity.this)) {  //Если сеть активна...
                    textView.setText("Загрузка...");
                    Intent intent = new Intent(NetworkActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {  //если нет сети
                    textView.setText("Проверьте подключение к сети");
                }
            }
        });

    }

    //Обработка нажатия кнопки "назад"
    private static long back_pressed = 0;
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            finish();
        }
        else
            Toast.makeText(getBaseContext(), "Для выхода нажмите еще раз \"назад\"",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}

