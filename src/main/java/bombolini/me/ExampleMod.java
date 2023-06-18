package bombolini.me;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("template-mod");
	public static final Item CUSTOM_ITEM = new CustomItem(new FabricItemSettings());

	/*
	 * Registers our Cube Entity under the ID "ExampleMod:cube".
	 *
	 * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
	 * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
	 */
	public static final EntityType<CubeEntity> CUBE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("template-mod", "cube"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello world!");

		Registry.register(Registry.ITEM, new Identifier("template-mod", "custom_item"), CUSTOM_ITEM);

		/*
		 * Register our Cube Entity's default attributes.
		 * Attributes are properties or stats of the mobs, including things like attack damage and health.
		 * The game will crash if the entity doesn't have the proper attributes registered in time.
		 *
		 * In 1.15, this was done by a method override inside the entity class.
		 * Most vanilla entities have a static method (eg. ZombieEntity#createZombieAttributes) for initializing their attributes.
		 */
		FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());

	}
}

//TODO:

/**
 * Ability to right click things
 * Basic pathfinding
 *
 * */