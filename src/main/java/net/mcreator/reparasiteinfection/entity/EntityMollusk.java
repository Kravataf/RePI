
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.reparasiteinfection.procedure.ProcedureParasiteTag;
import net.mcreator.reparasiteinfection.item.ItemBrokenCore;
import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsReParasiteInfection.ModElement.Tag
public class EntityMollusk extends ElementsReParasiteInfection.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityMollusk(ElementsReParasiteInfection instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("reparasiteinfection", "mollusk"), ENTITYID).name("mollusk").tracker(64, 3, true).egg(-1, -1).build());
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
			return new RenderLiving(renderManager, new Modelmollusk(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("reparasiteinfection:textures/mollusk_texture.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 0.5f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIPanic(this, 1.2));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAISwimming(this));
			this.tasks.addTask(5, new EntityAILeapAtTarget(this, (float) 1));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemBrokenCore.block, (int) (1)).getItem();
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
		public void onEntityUpdate() {
			super.onEntityUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureParasiteTag.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}
	}

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
}
