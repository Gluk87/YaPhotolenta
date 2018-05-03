package forlife.photolenta.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.google.gson.Gson;
import java.util.concurrent.ExecutionException;

import forlife.photolenta.R;
import forlife.photolenta.data.database.DB;
import forlife.photolenta.data.Connect;
import forlife.photolenta.domain.ImageAdapter;
import forlife.photolenta.data.postmodel.POJO;


public class GoActivity extends AppCompatActivity {
    Connect connect;
    String str;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect = new Connect();
        connect.execute(); // Для соединения к папке в Яндекс.Диске HttpUrlConnection
        try {
            str = connect.get(); //забираем данные в формате JSON
            str = str.substring(str.indexOf("["), str.indexOf("]")+1);
            db = new DB(getApplicationContext());
            db.open(); // Открываем подключение к БД
            db.create_table(); // Если первый запуск, создаем таблицу (create table if not exists)
            db.truncate_table(); // очищаем таблицу

            Gson gson = new Gson(); // Используем библиотеку JSON для конвертации JSON в объекты
            // JAVA-классы сконвертированы из JSON  с помощью сервиса jsonschema2pojo
            POJO.Embedded.Item[] pojo = gson.fromJson(str, POJO.Embedded.Item[].class);
            for (POJO.Embedded.Item aPojo : pojo) {
                db.addRec(aPojo.file, aPojo.name); // инсертим URL изображений в таблицу
            }
            db.close(); // закрываем подключение к БД

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        final GridView gridview = findViewById(R.id.gridView); // для отображения изображений в виде плитки используем GridView
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i = new Intent(getApplicationContext(),ViewPagerActivity.class);
                i.putExtra("id", position); // передаем позицию изображения
                startActivity(i);
            }
        });

    }
}

