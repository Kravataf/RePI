public static class Modelmollusk extends ModelBase {
	private final ModelRenderer body1;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer body6;
	private final ModelRenderer body7;
	private final ModelRenderer wing2;
	private final ModelRenderer wing3;

	public Modelmollusk() {
		textureWidth = 32;
		textureHeight = 32;

		body1 = new ModelRenderer(this);
		body1.setRotationPoint(0.0F, 22.0F, -6.0F);
		body1.cubeList.add(new ModelBox(body1, 0, 15, -1.5F, 0.0F, -1.0F, 3, 2, 2, 0.0F, false));

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 21.0F, -4.0F);
		body2.cubeList.add(new ModelBox(body2, 0, 10, -2.0F, 0.0F, -1.0F, 4, 3, 2, 0.0F, false));

		body3 = new ModelRenderer(this);
		body3.setRotationPoint(0.0F, 20.0F, -1.5F);
		body3.cubeList.add(new ModelBox(body3, 0, 0, -3.0F, 0.0F, -1.5F, 6, 4, 6, 0.0F, false));

		body4 = new ModelRenderer(this);
		body4.setRotationPoint(0.0F, 21.0F, 1.5F);
		body4.cubeList.add(new ModelBox(body4, 12, 10, -1.5F, 0.0F, 1.5F, 3, 3, 2, 0.0F, false));

		body5 = new ModelRenderer(this);
		body5.setRotationPoint(0.0F, 22.0F, 4.5F);
		body5.cubeList.add(new ModelBox(body5, 10, 15, -1.0F, 0.0F, 0.5F, 2, 2, 2, 0.0F, false));

		body6 = new ModelRenderer(this);
		body6.setRotationPoint(0.0F, 23.0F, 7.0F);

		body7 = new ModelRenderer(this);
		body7.setRotationPoint(0.0F, 23.0F, 9.0F);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(0.0F, 20.0F, 4.5F);

		wing3 = new ModelRenderer(this);
		wing3.setRotationPoint(0.0F, 19.0F, -4.0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body1.render(f5);
		body2.render(f5);
		body3.render(f5);
		body4.render(f5);
		body5.render(f5);
		body6.render(f5);
		body7.render(f5);
		wing2.render(f5);
		wing3.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}