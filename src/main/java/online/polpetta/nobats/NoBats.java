package online.polpetta.nobats;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoBats implements ModInitializer {

  public static final String MOD_ID = "no-bats";

  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    BiomeModifications.create(Identifier.of("online.polpetta", MOD_ID))
        .add(ModificationPhase.REMOVALS, BiomeSelectors.all(),
            (context -> context.getSpawnSettings().removeSpawnsOfEntityType(
                EntityType.BAT)));

    LOGGER.info("[NoBats] Bats will no longer spawn");
  }
}
