package cosmic.particl.conjurerscookbook.registries;

import com.google.common.base.Preconditions;
import cosmic.particl.conjurerscookbook.block.Mandrakecrop;
import cosmic.particl.conjurerscookbook.conjurerscookbook;
import cosmic.particl.conjurerscookbook.item.Foods;
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
            final Item[] items = {
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.berry_cream).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("berry_cream")),
                    new SoupItem(new Item.Properties().group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.bamboo_curry).containerItem(Items.BOWL).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("bamboo_curry")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.cookie_tin).rarity(Rarity.RARE)).setRegistryName(conjurerscookbook.location("cookie_tin")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(1).food(Foods.cake).rarity(Rarity.RARE)).setRegistryName(conjurerscookbook.location("cake")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(64).food(Foods.chorus).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("chorus")),
                    new Item((new Item.Properties()).group(conjurerscookbook.GROUP).maxStackSize(64).food(Foods.mandrake_root).rarity(Rarity.COMMON)).setRegistryName(conjurerscookbook.location("mandrake_root"))
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
