package dev.enjarai.svfe.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.TemptTask;
import net.minecraft.entity.ai.brain.task.TemptationCooldownTask;
import net.minecraft.entity.ai.brain.task.VillagerTaskListProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VillagerTaskListProvider.class)
public abstract class VillagerTaskListProviderMixin {
	@ModifyArg(
			method = "createCoreTasks",
			at = @At(
					value = "INVOKE",
					target = "Lcom/google/common/collect/ImmutableList;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;"
			)
	)
	private static Object[] addTemptationAsCoreTask(Object[] original) {
		Object[] modified = new Object[original.length + 2];
		System.arraycopy(original, 0, modified, 0, original.length);
		modified[original.length] = Pair.of(0, new TemptTask(e -> 0.5f));
		modified[original.length + 1] = Pair.of(0, new TemptationCooldownTask(MemoryModuleType.TEMPTATION_COOLDOWN_TICKS));
		return modified;
	}
}