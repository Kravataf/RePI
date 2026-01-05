package net.mcreator.reparasiteinfection.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.reparasiteinfection.ElementsReParasiteInfection;

@ElementsReParasiteInfection.ModElement.Tag
public class ProcedureParasiteSpawn extends ElementsReParasiteInfection.ModElement {
	public ProcedureParasiteSpawn(ElementsReParasiteInfection instance) {
		super(instance, 2);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ParasiteSpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getEntityData().setBoolean("ReParasite", (true));
	}
}
