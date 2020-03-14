package cosmic.particl.conjurerscookbook.item;

import net.minecraft.item.Item;

public class MandrakeSeeds extends Item {
    public MandrakeSeeds(){
        super (new Item.Properties()
                .maxStackSize(64)
        );
        setRegistryName("mandrake_seeds");
    }
}
