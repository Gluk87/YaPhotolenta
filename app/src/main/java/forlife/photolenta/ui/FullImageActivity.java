package forlife.photolenta.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import forlife.photolenta.R;
import forlife.photolenta.domain.ImageAdapter;

public class FullImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this);
        // Библиотеку PhotoView вместо ImageView используем для функции Zoom
        PhotoView photoView = findViewById(R.id.full_image_view);
        Picasso.with(this).load(imageAdapter.mThumbIds[position]).into(photoView);
    }
}
