package net.mcreator.reparasiteinfection.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

import net.mcreator.reparasiteinfection.ReParasiteInfectionVariables;
import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

@ElementsReParasiteInfection.ModElement.Tag
public class ProcedureGetRePointsExec extends ElementsReParasiteInfection.ModElement {
	public ProcedureGetRePointsExec(ElementsReParasiteInfection instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GetRePointsExec!");
			return;
		}
		World world = (World) dependencies.get("world");
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(
						new TextComponentString((("RePoints: ") + "" + ((ReParasiteInfectionVariables.MapVariables.get(world).RePoints)))));
		}
	}
}
