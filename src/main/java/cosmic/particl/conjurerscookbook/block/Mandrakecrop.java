package cosmic.particl.conjurerscookbook.block;

import cosmic.particl.conjurerscookbook.registries.conjurerscookbooksounds;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import cosmic.particl.conjurerscookbook.item.ItemHolder;

import java.util.Random;

public class Mandrakecrop extends CropsBlock{

    public static final IntegerProperty MANDRAKE_AGE = BlockStateProperties.AGE_0_3;

    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};

    public Mandrakecrop() {
        super(Properties.create(Material.PLANTS)
                .sound(SoundType.PLANT)
                .doesNotBlockMovement()
                .tickRandomly()
        );
        setRegistryName("mandrake_crop");
    }


    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        worldIn.playSound(player,
                player.getPosX(),
                player.getPosY(),
                player.getPosZ(),
                conjurerscookbooksounds.mandrake_scream,
                SoundCategory.NEUTRAL,
                1.0F,
                1.0F);
        super.onBlockHarvested(worldIn, pos, state, player);
    }


    protected IItemProvider getSeedsItem() { return ItemHolder.mandrake_seeds;}

    public IntegerProperty getAgeProperty() {
        return MANDRAKE_AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) != 0) {
            super.tick(state, worldIn, pos, rand);
        }

    }

    protected int getBonemealAgeIncrease(World worldIn) {
        return super.getBonemealAgeIncrease(worldIn) / 3;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(MANDRAKE_AGE);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(this.getAgeProperty())];
    }

    }
