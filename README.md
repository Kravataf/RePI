# Re: Parasite Infection

1.12.2 forge mcreator 2020.2 <= other 1.12.2 generators for newer versions were lowkey ass so I gave up on trying to use them and instead write stuff in Java

Sounds are from zapsplat

# Systems/ other stuff

Kill by parasite looks if there's a parasite variant. If not => fallback to placeholder parasite entity

They target LivingEntity but only if ReParasite nbt tag is false

```
// some dependencies
import net.minecraft.entity.EntityLivingBase;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.mcreator.reparasiteinfection.ReParasiteInfectionVariables;

// override AttackableTarget w/ this
this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, false, false, new Predicate<EntityLivingBase>() {
  @Override
  public boolean apply(@Nullable EntityLivingBase entity) {
    return entity != null && !entity.getEntityData().getBoolean("ReParasite");
  }
}));
```

There are also phases which are unlocked after parasites reach certain amount of RePoints (GLOBAL_MAP) <= these phases should do some stuff like change what parasites spawn, etc. etc. but I haven't implemented that yet

Alsoo custom spawning so they can spawn anywhere at any time !! (+ spawnrate modifier)

# Phases

spawnrate is exponential from the base 20, i'll probably have to rebalance this later but idkk (0 = 20, 1 = 40, 2 = 80, 3 = 160, ...)
