package forlife.photolenta.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//Класс по управлению БД
public class DB {
    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;
    private final Context mCtx;
    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    // открыть подключение
    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    // закрыть подключение
    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }

    public void create_table() {
        mDB.execSQL(DB_CREATE);
    }

    public void truncate_table() {
        mDB.execSQL("delete from " + DB_TABLE + ";");
    }

    private static final String DB_TABLE = "dbmain";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FILE = "db_file";
    private static final String COLUMN_NAME = "db_name";
    private static final String COLUMN_DAT = "db_dat";

    private static final String DB_CREATE =
            "create table if not exists " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_FILE + " text, " +
                    COLUMN_NAME + " text, " +
                    COLUMN_DAT + " date" +
                    ");";

    // добавить запись в DB_TABLE
    public void addRec(String txt1, String txt2) {
        ContentValues cv = new ContentValues();
        long date = System.currentTimeMillis(); //текущее время

        cv.put(COLUMN_FILE, txt1);
        cv.put(COLUMN_NAME, txt2);
        cv.put(COLUMN_DAT, date);
        mDB.insert(DB_TABLE, null, cv);
    }

    // чтение URL из таблицы
    public Cursor getUrls()
    {
        String[] columns={COLUMN_FILE};
        return mDB.query(DB_TABLE,columns,null,null,null,null,null);
    }
}

