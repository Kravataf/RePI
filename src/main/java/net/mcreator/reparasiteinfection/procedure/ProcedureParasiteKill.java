package net.mcreator.reparasiteinfection.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.Entity;

import net.mcreator.reparasiteinfection.entity.EntityTaintedPig;
import net.mcreator.reparasiteinfection.entity.EntityTaintedHumanoid;
import net.mcreator.reparasiteinfection.entity.EntityMollusk;
import net.mcreator.reparasiteinfection.ReParasiteInfectionVariables;
import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

@ElementsReParasiteInfection.ModElement.Tag
public class ProcedureParasiteKill extends ElementsReParasiteInfection.ModElement {
	public ProcedureParasiteKill(ElementsReParasiteInfection instance) {
		super(instance, 3);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ParasiteKill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ParasiteKill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ParasiteKill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ParasiteKill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ParasiteKill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		boolean found = false;
		ReParasiteInfectionVariables.MapVariables
				.get(world).RePoints = (double) ((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) + 1);
		ReParasiteInfectionVariables.MapVariables.get(world).syncData(world);
		found = (boolean) (false);
		if ((entity instanceof EntityVillager)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityTaintedHumanoid.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			found = (boolean) (true);
		}
		if ((entity instanceof EntityZombie)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityTaintedHumanoid.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			found = (boolean) (true);
		}
		if ((entity instanceof EntityZombieVillager)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityTaintedHumanoid.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			found = (boolean) (true);
		}
		if ((entity instanceof EntityPig)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityTaintedPig.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			found = (boolean) (true);
		}
		if (((found) == (false))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityMollusk.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("fallback"));
			}
		} else {
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("found"));
			}
		}
	}
}
