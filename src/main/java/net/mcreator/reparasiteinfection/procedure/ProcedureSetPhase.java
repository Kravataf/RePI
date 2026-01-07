package net.mcreator.reparasiteinfection.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

import net.mcreator.reparasiteinfection.ReParasiteInfectionVariables;
import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

@ElementsReParasiteInfection.ModElement.Tag
public class ProcedureSetPhase extends ElementsReParasiteInfection.ModElement {
	public ProcedureSetPhase(ElementsReParasiteInfection instance) {
		super(instance, 7);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SetPhase!");
			return;
		}
		World world = (World) dependencies.get("world");
		if ((((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) >= 20)
				&& ((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) < 100))) {
			ReParasiteInfectionVariables.MapVariables.get(world).Phase = (double) 1;
			ReParasiteInfectionVariables.MapVariables.get(world).syncData(world);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("1"));
			}
		}
		if ((((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) >= 100)
				&& ((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) < 1000))) {
			ReParasiteInfectionVariables.MapVariables.get(world).Phase = (double) 2;
			ReParasiteInfectionVariables.MapVariables.get(world).syncData(world);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("2"));
			}
		}
		if ((((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) >= 1000)
				&& ((ReParasiteInfectionVariables.MapVariables.get(world).RePoints) < 9999))) {
			ReParasiteInfectionVariables.MapVariables.get(world).Phase = (double) 3;
			ReParasiteInfectionVariables.MapVariables.get(world).syncData(world);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("3"));
			}
		}
	}
}
