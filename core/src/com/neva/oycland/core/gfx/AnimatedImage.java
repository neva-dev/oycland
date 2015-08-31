package com.neva.oycland.core.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.neva.oycland.core.control.Controller;

public class AnimatedImage extends Image {

    private final AnimatedImageController animationController;

    protected Animation animation;

    protected float moveSpeed = 100f;

    private float stateTime;

    public AnimatedImage(Controller controller, AnimationFactory moveFactory) {
        super(moveFactory.getStand().getKeyFrame(0));

        this.animationController = new AnimatedImageController(this, moveFactory, controller);
        this.animation = moveFactory.getStand();
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

        animationController.control(delta);
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void resize(float widthScale, float heightScale) {
        setSize(getWidth() * widthScale, getHeight() * heightScale);
    }

    public void resize(float scale) {
        resize(scale, scale);
    }
}