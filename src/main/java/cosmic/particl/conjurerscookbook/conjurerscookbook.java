package cosmic.particl.conjurerscookbook;


import cosmic.particl.conjurerscookbook.item.ItemHolder;
import cosmic.particl.conjurerscookbook.proxy.ClientProxy;
import cosmic.particl.conjurerscookbook.proxy.IProxy;
import cosmic.particl.conjurerscookbook.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Mod(conjurerscookbook.MODID)
public class conjurerscookbook {
    public static final String MODID = "conjurerscookbook";
    public static final String VERSION = "0.0.3";

    public static IProxy PROXY = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final Logger LOGGER = LogManager.getLogger(conjurerscookbook.MODID);



    private void OnLoadComplete(final FMLLoadCompleteEvent event) {
        PROXY.init();
    }

    public static String getVersion(boolean correctInDev) {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(conjurerscookbook.MODID);
        if (o.isPresent()) {
            String str = o.get().getModInfo().getVersion().toString();
            if (correctInDev && "NONE".equals(str))
                return conjurerscookbook.VERSION;
            return str;
        }
        return "0.0.0";
    }

    public static boolean isDevBuild() {
        return "NONE".equals(getVersion(false));
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(conjurerscookbook.MODID, name);
    }

    public static final ItemGroup GROUP = new ItemGroup(conjurerscookbook.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemHolder.cookie_tin);
        }
    };
}
