public static class ModeltaintedPig extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer tentacle1;
	private final ModelRenderer bone2;
	private final ModelRenderer bone4;
	private final ModelRenderer bone3;
	private final ModelRenderer tentacle2;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer tentacle3;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer tentacle4;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;

	public ModeltaintedPig() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 11.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 28, 8, -5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 11.0F, -7.0F);
		setRotationAngle(head, 0.6109F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 16, -2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-3.0F, 18.0F, 7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(3.0F, 18.0F, 7.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.0F, 18.0F, -5.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(3.0F, 18.0F, -5.0F);
		leg4.cubeList.add(new ModelBox(leg4, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		tentacle1 = new ModelRenderer(this);
		tentacle1.setRotationPoint(1.0F, 17.0F, 0.0F);
		setRotationAngle(tentacle1, 1.5708F, 0.5236F, 2.0071F);
		tentacle1.cubeList.add(new ModelBox(tentacle1, 0, 27, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 6.0F);
		tentacle1.addChild(bone2);
		setRotationAngle(bone2, 0.48F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone2.addChild(bone4);
		setRotationAngle(bone4, 0.7854F, 0.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone4.addChild(bone3);
		setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 2, 27, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));

		tentacle2 = new ModelRenderer(this);
		tentacle2.setRotationPoint(-1.0F, 17.0F, 0.0F);
		setRotationAngle(tentacle2, 1.5708F, -0.5236F, -2.0071F);
		tentacle2.cubeList.add(new ModelBox(tentacle2, 0, 27, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 6.0F);
		tentacle2.addChild(bone5);
		setRotationAngle(bone5, 0.48F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.7854F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone6.addChild(bone7);
		setRotationAngle(bone7, 0.6981F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 2, 27, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));

		tentacle3 = new ModelRenderer(this);
		tentacle3.setRotationPoint(1.0F, 11.0F, 0.0F);
		setRotationAngle(tentacle3, 1.1071F, 0.2527F, 0.9F);
		tentacle3.cubeList.add(new ModelBox(tentacle3, 0, 27, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 6.0F);
		tentacle3.addChild(bone8);
		setRotationAngle(bone8, 0.48F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.7854F, 0.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.6981F, 0.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 2, 27, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));

		tentacle4 = new ModelRenderer(this);
		tentacle4.setRotationPoint(-1.0F, 11.0F, 0.0F);
		setRotationAngle(tentacle4, 1.1071F, -0.2527F, -0.9F);
		tentacle4.cubeList.add(new ModelBox(tentacle4, 0, 27, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 6.0F);
		tentacle4.addChild(bone11);
		setRotationAngle(bone11, 0.48F, 0.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.7854F, 0.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 0, 26, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 7.0F);
		bone12.addChild(bone13);
		setRotationAngle(bone13, 0.6981F, 0.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 2, 27, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		tentacle1.render(f5);
		tentacle2.render(f5);
		tentacle3.render(f5);
		tentacle4.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}