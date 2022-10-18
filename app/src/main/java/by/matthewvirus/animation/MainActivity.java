package by.matthewvirus.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView sunImageView;
    private ImageView moonImageView;
    private ImageSwitcher skyImageSwitcher;
    private ImageSwitcher grassImageSwitcher;

    private Animation sunRiseAnimation;
    private Animation moonRiseAnimation;
    private Animation inAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sunImageView = findViewById(R.id.sun);
        moonImageView = findViewById(R.id.moon);
        skyImageSwitcher = findViewById(R.id.sky_switcher);
        grassImageSwitcher = findViewById(R.id.grass_switcher);

        inAnimation = new AlphaAnimation(1, 0);
        inAnimation.setStartOffset(7000);
        inAnimation.setDuration(10000);

        sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.day_animation);
        moonRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.night_animation);
        moonRiseAnimation.setStartOffset(7000);

        sunImageView.startAnimation(sunRiseAnimation);
        moonImageView.startAnimation(moonRiseAnimation);

        if (sunImageView.getX() < 0) {
            skyImageSwitcher.showNext();
            grassImageSwitcher.showNext();
            skyImageSwitcher.startAnimation(inAnimation);
            grassImageSwitcher.startAnimation(inAnimation);
        }
    }
}