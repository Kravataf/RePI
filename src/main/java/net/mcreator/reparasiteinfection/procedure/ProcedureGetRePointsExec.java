package net.mcreator.reparasiteinfection.procedure;

import net.minecraft.world.World;

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
		System.out.println((ReParasiteInfectionVariables.MapVariables.get(world).RePoints));
	}
}
