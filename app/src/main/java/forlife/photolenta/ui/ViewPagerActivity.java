package forlife.photolenta.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import forlife.photolenta.R;
import forlife.photolenta.domain.PhotoViewPager;
import forlife.photolenta.domain.ViewPagerAdapter;

public class ViewPagerActivity extends Activity {

    private static final String ISLOCKED_ARG = "isLocked";

    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");

        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ViewPagerAdapter(this));
        mViewPager.setCurrentItem(position);
    }

    // Фиксируем состояние активности
    private boolean isViewPagerActive() {
        return (mViewPager != null && mViewPager instanceof PhotoViewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (isViewPagerActive()) {
            outState.putBoolean(ISLOCKED_ARG, ((PhotoViewPager) mViewPager).isLocked());
        }
        super.onSaveInstanceState(outState);
    }

}

