public static class ModelIncompleteForm extends ModelBase {
	private final ModelRenderer root;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public ModelIncompleteForm() {
		textureWidth = 128;
		textureHeight = 128;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.cubeList.add(new ModelBox(root, 0, 0, -9.0F, -6.0F, -9.0F, 18, 6, 18, 0.0F, false));
		root.cubeList.add(new ModelBox(root, 56, 24, -4.0F, -20.0F, -4.0F, 8, 6, 8, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -13.0F, 0.0F);
		root.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.088F, 0.1304F, -0.0115F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 45, -6.0F, -2.0F, -6.0F, 12, 4, 12, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.5F, -18.0F, 2.0F);
		root.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.4943F, 0.2316F, -0.6467F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 48, 59, -2.5F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(5.5F, -7.0F, -3.0F);
		root.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.1854F, -0.326F, 0.4395F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 48, 45, -4.5F, -2.0F, -5.0F, 9, 4, 10, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -8.5F, 0.0F);
		root.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0873F, -0.1745F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 24, -7.0F, -3.5F, -7.0F, 14, 7, 14, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
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