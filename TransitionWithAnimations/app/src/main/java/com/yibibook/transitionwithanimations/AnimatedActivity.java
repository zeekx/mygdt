package com.yibibook.transitionwithanimations;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class AnimatedActivity extends AppCompatActivity {

    public static final String EXTRA_ANIMATION_STYLE = "com.yibook.twa.animatedActivity.animationStyle";
    public static final String ANIMATION_STYLE_FADE = "fade";
    public static final String ANIMATION_STYLE_EXPLODE = "explode";
    public static final String ANIMATION_STYLE_SLIDE = "slide";

    private static final String TRANSITION_ANDROID = "switchAndroid";
    private static final String TRANSITION_BLUE = "switchBlue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated);

        final Transition transition = getTransitionFromExtra();
        if (transition != null) {
            getWindow().setEnterTransition(transition);
        }
    }

    @Nullable
    private Transition getTransitionFromExtra() {
        String style = getIntent().getStringExtra(EXTRA_ANIMATION_STYLE);
        Transition transition = null;
        if (TextUtils.equals(style, ANIMATION_STYLE_FADE)) {
            transition = new Fade();
        } else if (TextUtils.equals(style, ANIMATION_STYLE_EXPLODE)) {
            transition = new Explode();
        } else if (TextUtils.equals(style, ANIMATION_STYLE_SLIDE)) {
            transition = new Slide();
        }
        return transition;
    }

    public void explodeAnimation(final Context context, View view) {
        view.setOnClickListener(v -> {
            getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(context, context.getClass());
            intent.putExtra(EXTRA_ANIMATION_STYLE, ANIMATION_STYLE_EXPLODE);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity)context)).toBundle());
        });
    }


    public void slideAnimation(final Context context, View view) {
        view.setOnClickListener(v -> {
            getWindow().setExitTransition(new Slide());
            Intent intent = new Intent(context, context.getClass());
            intent.putExtra(EXTRA_ANIMATION_STYLE, ANIMATION_STYLE_SLIDE);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity)context)).toBundle());
        });
    }


    public void rotateAnimation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.ROTATION, 0f, 360f);
        animator.setDuration(260);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        view.setOnClickListener(v ->
            animator.start()
        );

    }


    public void switchAnimation(final ImageView androidImage,
                                final ImageView otherImage,
                                final Intent intent,
                                final Context context) {
        androidImage.setOnClickListener(v -> {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation((Activity)context,
                            new Pair(androidImage, TRANSITION_ANDROID),
                            new Pair(otherImage, TRANSITION_BLUE));

            startActivity(intent, options.toBundle());
        });
    }

}
