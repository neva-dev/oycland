package com.neva.oycland.core.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;
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
        this.stateTime = 0;
    }

    @Override
    public void act(float delta) {
        ((TextureRegionDrawable) getDrawable()).setRegion(animation.getKeyFrame(stateTime += delta, true));
        super.act(delta);
    }
}