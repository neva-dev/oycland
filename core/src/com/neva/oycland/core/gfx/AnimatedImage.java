package com.neva.oycland.core.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class AnimatedImage extends Image {

    protected Animation animation;

    private float stateTime;

    public AnimatedImage(Animation animation) {
        super(animation.getKeyFrame(0));

        this.animation = animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void act(float delta) {
        stateTime += delta;

        TextureRegion keyFrame = animation.getKeyFrame(stateTime, true);
        ((TextureRegionDrawable) getDrawable()).setRegion(keyFrame);

        super.act(delta);
    }
}