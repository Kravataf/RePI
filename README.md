# Re: Parasite Infection

made using 1.12.2 forge mcreator 2020.2

# About

Mollusk will spawn anytime, anywhere in the world and infect mobs (+compat w/ other mods!), those will turn into their tainted version or/ fallback to some placeholder tainted. then all infected mobs, parasites, etc. infect more and this repeats basically. Id like to add phases/evolutions someday similar to srp but yh

# Systems

ATTACKING
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

SPAWNING
```

```

# Credits

sfx from zapsplat rest made by me . inspired by srp, parasyte, tokyo ghoul, etc. etc.