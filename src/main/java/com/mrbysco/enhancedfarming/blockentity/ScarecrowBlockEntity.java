package com.mrbysco.enhancedfarming.blockentity;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class ScarecrowBlockEntity extends BlockEntity {
	private final List<PathfinderMob> entityList = new ArrayList<>();
	private final AABB hitbox;

	public ScarecrowBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
		super(blockEntityType, pos, state);
		this.hitbox = new AABB(pos.getX() - 0.5f, pos.getY() - 0.5f, pos.getZ() - 0.5f,
				pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f)
				.inflate(-5, -5, -5).inflate(5, 5, 5);
	}

	public ScarecrowBlockEntity(BlockPos pos, BlockState state) {
		this(FarmingRegistry.SCARECROW_TILE.get(), pos, state);
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, ScarecrowBlockEntity blockEntity) {
		if (level != null) {
			if (level.getGameTime() % 10 == 0) {
				blockEntity.entityList.clear();
				blockEntity.entityList.addAll(level.getEntitiesOfClass(PathfinderMob.class, blockEntity.hitbox).stream()
						.filter(entity -> entity instanceof Animal || entity instanceof WaterAnimal).map(entity -> entity).toList());
			}

			if (blockEntity.entityList != null && !blockEntity.entityList.isEmpty()) {
				for (PathfinderMob animal : blockEntity.entityList) {
					final Vec3 animalPos = getInvertedDirection(pos, animal);
					animal.moveRelative(0.05F, animalPos);
				}
			}
		}
	}

	public static Vec3 getInvertedDirection(BlockPos scarecrow, Entity animal) {
		double x = (animal.getX() < scarecrow.getX() ? 1 : 0);
		double z = (animal.getZ() < scarecrow.getZ() ? 1 : 0);

		return new Vec3(animal.getX() + x, 0.5, animal.getZ() + z);
	}
}
