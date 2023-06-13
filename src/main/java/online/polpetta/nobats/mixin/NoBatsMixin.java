package online.polpetta.nobats.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BatEntity.class)
public class NoBatsMixin {
  @Inject(at = @At("HEAD"),
          method = "canSpawn("
                   + "Lnet/minecraft/entity/EntityType;"
                   + "Lnet/minecraft/world/WorldAccess;"
                   + "Lnet/minecraft/entity/SpawnReason;"
                   + "Lnet/minecraft/util/math/BlockPos;"
                   + "Lnet/minecraft/util/math/random/Random;"
                   + ")Z",
          cancellable = true)
  private static void
  canSpawn(EntityType<BatEntity> type, WorldAccess world,
           SpawnReason spawnReason, BlockPos pos, Random random,
           CallbackInfoReturnable<Boolean> info) {
    info.setReturnValue(false);
  }
}
