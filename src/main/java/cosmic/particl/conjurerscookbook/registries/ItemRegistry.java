package cosmic.particl.conjurerscookbook.registries;

import com.google.common.base.Preconditions;
import cosmic.particl.conjurerscookbook.block.BlockHolder;
import cosmic.particl.conjurerscookbook.block.Mandrakecrop;
import cosmic.particl.conjurerscookbook.conjurerscookbook;
import cosmic.particl.conjurerscookbook.item.Foods;
import cosmic.particl.conjurerscookbook.item.ItemHolder;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(conjurerscookbook.MODID)
//Registers Items and Blocks. Name Depreciated
public class ItemRegistry {
    @Mod.EventBusSubscriber(modid = conjurerscookbook.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void RegisterItems(final RegistryEvent.Register<Item> event) {
            final Item[] items = new Item[]{
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.berry_cream).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("berry_cream")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.bamboo_curry).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("bamboo_curry")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.cookie_tin).rarity(Rarity.RARE)).setRegistryName(conjurerscookbook.location("cookie_tin")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.cake).rarity(Rarity.RARE)).setRegistryName(conjurerscookbook.location("cake")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(64).food(Foods.chorus).rarity(Rarity.RARE)).setRegistryName(conjurerscookbook.location("chorus")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(64).food(Foods.mandrake_root).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("mandrake_root")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.neptune_stew).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("neptune_stew")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.witchs_stew).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("witchs_stew")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.sacrifice_stew).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("sacrifice_stew")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.undead_delicacy).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("undead_delicacy")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.veggie_mix).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("veggie_mix")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(64).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("bottledmandrake")),

                    new BlockItem(BlockHolder.MANDRAKE_CROP, (new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(64).rarity(Rarity.COMMON))).setRegistryName("mandrake_seeds")
            };

            for (final Item item: items) {
                Preconditions.checkNotNull(item.getRegistryName(), "Block: %s has a NULL registry name", item);
                event.getRegistry().register(item);
            }
        }

        @SubscribeEvent
        public static void RegisterBlocks(final RegistryEvent.Register<Block> event){
            event.getRegistry().register(new Mandrakecrop());
        }

    }
}
