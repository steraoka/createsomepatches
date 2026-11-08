package com.syuseigame.CreateSomePatches.block;

import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.fluid.ModFluidType;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS=
            DeferredRegister.createBlocks(createsomepatches.MOD_ID);
//-----追加するブロック群-----
    public static final DeferredBlock<Block> RAINBOW_DIAMOND_BLOCK = registerBlock(
            "rainbow_diamond_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    //硬度
                    .strength(4.0f)
                    //ドロップ
                    .requiresCorrectToolForDrops()
                    //音
                    .sound(SoundType.AMETHYST)));
    public static final DeferredBlock<LiquidBlock> HEATED_LAVA_BLOCK = BLOCKS.register("heated_lava_block",
            () -> new LiquidBlock(ModFluidType.SOURCE.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name,Supplier<T> block){
        DeferredBlock<T> registered = BLOCKS.register(name,block);
        registerBlockItem(name,registered);
        return registered;
    }

    private static<T extends  Block> void registerBlockItem(String name,DeferredBlock<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
