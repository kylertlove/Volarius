package net.nerds.volarius.mixin;


import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ItemMixin {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo callbackInfo) {

        System.out.println("pointless right now.  i just dont understand mixins so im not deleting this file");

    }
}
