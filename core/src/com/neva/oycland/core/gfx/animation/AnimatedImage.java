package com.neva.oycland.core.gfx.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.neva.oycland.core.control.Controller;

public class AnimatedImage extends Image {

    protected Animation animation;
    protected float moveSpeed = 100f;
    private AnimatedImageController animationController;
    private float stateTime;

    public AnimatedImage(AnimationFactory factory) {
        super(factory.getAnimation().getKeyFrame(0));

        this.animation = factory.getAnimation();
    }

    public AnimatedImage(Controller controller, AnimatedMoveFactory factory) {
        super(factory.getStand().getKeyFrame(0));

        this.animationController = new AnimatedImageController(this, factory, controller);
        this.animation = factory.getStand();
    }

    @Override
    public void act(float delta) {
        stateTime += delta;

        TextureRegion keyFrame = animation.getKeyFrame(stateTime, true);
        ((TextureRegionDrawable) getDrawable()).setRegion(keyFrame);

        super.act(delta);

        if (isControllable()) {
            animationController.control(delta);
        }
    }

    public boolean isControllable() {
        return animationController != null && getStage() != null;
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

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}