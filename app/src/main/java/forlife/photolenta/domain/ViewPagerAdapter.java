package forlife.photolenta.domain;

import android.content.Context;
import android.database.Cursor;
import android.view.*;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import android.widget.TableRow.*;
import android.support.v4.view.*;

import forlife.photolenta.data.database.DB;

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private String[] mThumbIds;

    public ViewPagerAdapter(Context c) {
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

    @Override
    public int getCount() {
        return  mThumbIds.length;
    }

    private String getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {

        PhotoView photoView = new PhotoView(container.getContext());
        String url = getItem(position);
        Picasso.with(mContext) // Для загрузки изображений используем библиотеку Picasso
                .load(url)
                .into(photoView);
        container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}