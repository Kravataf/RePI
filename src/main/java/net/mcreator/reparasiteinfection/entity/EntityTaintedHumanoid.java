
package net.mcreator.reparasiteinfection.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.reparasiteinfection.procedure.ProcedureParasiteSpawn;
import net.mcreator.reparasiteinfection.procedure.ProcedureParasiteKill;
import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

import java.util.Iterator;
import java.util.ArrayList;
// added these
import net.minecraft.entity.EntityLivingBase;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;

@ElementsReParasiteInfection.ModElement.Tag
public class EntityTaintedHumanoid extends ElementsReParasiteInfection.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityTaintedHumanoid(ElementsReParasiteInfection instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("reparasiteinfection", "taintedhumanoid"), ENTITYID).name("taintedhumanoid").tracker(64, 3, true).egg(-1, -1)
				.build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 3, 30, EnumCreatureType.MONSTER, spawnBiomes);
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModeltaintedHumanoid_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("reparasiteinfection:textures/taintedumanoid_texture3.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, false, false, new Predicate<EntityLivingBase>() {
			    @Override
			    public boolean apply(@Nullable EntityLivingBase entity) {
			        return entity != null && !entity.getEntityData().getBoolean("ReParasite");
			    }
			}));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1, false));
			this.tasks.addTask(4, new EntityAIWander(this, 1));
			this.tasks.addTask(5, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAISwimming(this));
			this.tasks.addTask(7, new EntityAILeapAtTarget(this, (float) 1));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("reparasiteinfection:tainteddeath2"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onKillEntity(EntityLivingBase entity) {
			super.onKillEntity(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureParasiteKill.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onEntityUpdate() {
			super.onEntityUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureParasiteSpawn.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}
	}

	public static class ModeltaintedHumanoid_model extends ModelBase {
		private final ModelRenderer Waist;
		private final ModelRenderer Head;
		private final ModelRenderer Head_r1;
		private final ModelRenderer Body;
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
		private final ModelRenderer RightArm;
		private final ModelRenderer RightArm_r1;
		private final ModelRenderer LeftArm;
		private final ModelRenderer LeftArm_r1;
		private final ModelRenderer RightLeg;
		private final ModelRenderer RightLeg_r1;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer LeftLeg_r1;
		public ModeltaintedHumanoid_model() {
			textureWidth = 64;
			textureHeight = 64;
			Waist = new ModelRenderer(this);
			Waist.setRotationPoint(0.0F, 12.0F, 0.0F);
			setRotationAngle(Waist, 0.2182F, 0.0F, 0.0F);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -12.0F, -1.0F);
			Waist.addChild(Head);
			Head_r1 = new ModelRenderer(this);
			Head_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
			Head.addChild(Head_r1);
			setRotationAngle(Head_r1, 0.6545F, 0.0F, 0.0F);
			Head_r1.cubeList.add(new ModelBox(Head_r1, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -12.0F, 0.0F);
			Waist.addChild(Body);
			Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(1.0F, -7.0F, 2.0F);
			Waist.addChild(tentacle1);
			setRotationAngle(tentacle1, 0.8727F, 0.0F, 0.7854F);
			tentacle1.cubeList.add(new ModelBox(tentacle1, 0, 33, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, 6.0F);
			tentacle1.addChild(bone2);
			setRotationAngle(bone2, 0.48F, 0.0F, 0.0F);
			bone2.cubeList.add(new ModelBox(bone2, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone2.addChild(bone4);
			setRotationAngle(bone4, 0.7854F, 0.0F, 0.0F);
			bone4.cubeList.add(new ModelBox(bone4, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone4.addChild(bone3);
			setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
			bone3.cubeList.add(new ModelBox(bone3, 2, 33, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-1.0F, -7.0F, 2.0F);
			Waist.addChild(tentacle2);
			setRotationAngle(tentacle2, 0.8727F, 0.0F, -0.7854F);
			tentacle2.cubeList.add(new ModelBox(tentacle2, 0, 33, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 0.0F, 6.0F);
			tentacle2.addChild(bone5);
			setRotationAngle(bone5, 0.48F, 0.0F, 0.0F);
			bone5.cubeList.add(new ModelBox(bone5, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone5.addChild(bone6);
			setRotationAngle(bone6, 0.7854F, 0.0F, 0.0F);
			bone6.cubeList.add(new ModelBox(bone6, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone6.addChild(bone7);
			setRotationAngle(bone7, 0.6981F, 0.0F, 0.0F);
			bone7.cubeList.add(new ModelBox(bone7, 2, 33, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(1.0F, -5.0F, 2.0F);
			Waist.addChild(tentacle3);
			setRotationAngle(tentacle3, 0.8727F, 0.0F, 2.3562F);
			tentacle3.cubeList.add(new ModelBox(tentacle3, 0, 33, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 0.0F, 6.0F);
			tentacle3.addChild(bone8);
			setRotationAngle(bone8, 0.48F, 0.0F, 0.0F);
			bone8.cubeList.add(new ModelBox(bone8, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone8.addChild(bone9);
			setRotationAngle(bone9, 0.7854F, 0.0F, 0.0F);
			bone9.cubeList.add(new ModelBox(bone9, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone9.addChild(bone10);
			setRotationAngle(bone10, 0.6981F, 0.0F, 0.0F);
			bone10.cubeList.add(new ModelBox(bone10, 2, 33, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(-1.0F, -5.0F, 2.0F);
			Waist.addChild(tentacle4);
			setRotationAngle(tentacle4, 0.8727F, 0.0F, -2.3562F);
			tentacle4.cubeList.add(new ModelBox(tentacle4, 0, 33, -2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 0.0F, 6.0F);
			tentacle4.addChild(bone11);
			setRotationAngle(bone11, 0.48F, 0.0F, 0.0F);
			bone11.cubeList.add(new ModelBox(bone11, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone11.addChild(bone12);
			setRotationAngle(bone12, 0.7854F, 0.0F, 0.0F);
			bone12.cubeList.add(new ModelBox(bone12, 0, 32, -1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F, false));
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 0.0F, 7.0F);
			bone12.addChild(bone13);
			setRotationAngle(bone13, 0.6981F, 0.0F, 0.0F);
			bone13.cubeList.add(new ModelBox(bone13, 2, 33, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, -10.0F, 0.0F);
			Waist.addChild(RightArm);
			RightArm_r1 = new ModelRenderer(this);
			RightArm_r1.setRotationPoint(3.0F, 10.0F, 0.0F);
			RightArm.addChild(RightArm_r1);
			setRotationAngle(RightArm_r1, -2.9222F, -0.7761F, -0.0546F);
			RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 32, 48, -4.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F, false));
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, -10.0F, 0.0F);
			Waist.addChild(LeftArm);
			LeftArm_r1 = new ModelRenderer(this);
			LeftArm_r1.setRotationPoint(-1.0F, 8.0F, -3.0F);
			LeftArm.addChild(LeftArm_r1);
			setRotationAngle(LeftArm_r1, -3.0612F, -0.0343F, -0.4097F);
			LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 32, 48, 0.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F, false));
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg_r1 = new ModelRenderer(this);
			RightLeg_r1.setRotationPoint(1.9F, 12.0F, 0.0F);
			RightLeg.addChild(RightLeg_r1);
			setRotationAngle(RightLeg_r1, -0.0436F, -0.0873F, 0.0F);
			RightLeg_r1.cubeList.add(new ModelBox(RightLeg_r1, 16, 48, -3.9F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg_r1 = new ModelRenderer(this);
			LeftLeg_r1.setRotationPoint(-0.9F, 12.0F, -1.0F);
			LeftLeg.addChild(LeftLeg_r1);
			setRotationAngle(LeftLeg_r1, -0.0057F, 0.1308F, -0.044F);
			LeftLeg_r1.cubeList.add(new ModelBox(LeftLeg_r1, 16, 48, -0.1F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Waist.render(f5);
			RightLeg.render(f5);
			LeftLeg.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
