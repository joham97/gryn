package com.hebe.gryn.addons.gryn.entities;

import com.hebe.gryn.logic.entity.AnimatedEntity;

public class BackAndForwardEntity extends AnimatedEntity {

	private boolean forward;
	private float adjust;
	
	public BackAndForwardEntity(float x, float y, int textureID) {
		super(x, y, textureID);
		this.forward = true;
		this.percent = 0;
		this.adjust = (this.time / (this.countImages * 2));
	}

	@Override
	public void update(float delta) {
		if (this.forward) {
			this.percent += delta;
			if (this.percent > this.time - adjust) {
				this.percent = (this.time - adjust) - (this.percent - (this.time - adjust));
				this.forward = false;
			}
		}else {
			this.percent -= delta;
			if (this.percent < adjust) {
				this.percent = adjust - this.percent;
				this.forward = true;
			}
		}
	}
}
