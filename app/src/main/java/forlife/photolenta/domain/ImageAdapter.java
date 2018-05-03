package forlife.photolenta.domain;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import forlife.photolenta.R;
import forlife.photolenta.data.database.DB;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public  String[] mThumbIds;

    public ImageAdapter(Context c) {
        // преобразовываем курсор в массив
        mContext = c;
        DB db = new DB(c);
        db.open();
        Cursor cursor = db.getUrls();
        String array[] = new String[cursor.getCount()];
        int i = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            array[i] = cursor.getString(0);
            i++;
            cursor.moveToNext();
        }
        db.close();
        mThumbIds = array;
    }

   public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public String getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;


        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        String url = getItem(position);
        Picasso.with(mContext) // Для загрузки изображений используем библиотеку Picasso
                .load(url)
                .placeholder(R.drawable.null0)
                .fit()
                .centerCrop().into(imageView);
        return imageView;
    }
}