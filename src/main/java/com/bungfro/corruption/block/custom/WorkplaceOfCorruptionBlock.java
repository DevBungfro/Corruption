package com.bungfro.corruption.block.custom;

import com.bungfro.corruption.block.entity.ModBlockEntities;
import com.bungfro.corruption.block.entity.WorkplaceOfCorruptionBlockEntity;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class WorkplaceOfCorruptionBlock extends BaseEntityBlock {

    private static final Component CONTAINER_TITLE = Component.translatable("container.workplace_of_corruption");

    public WorkplaceOfCorruptionBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    private static final VoxelShape SHAPE =
            Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }



        @Override
        public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
            if (!pLevel.isClientSide()) {
                BlockEntity entity = pLevel.getBlockEntity(pPos);
                if(entity instanceof WorkplaceOfCorruptionBlockEntity) {
                    NetworkHooks.openScreen(((ServerPlayer)pPlayer), (WorkplaceOfCorruptionBlockEntity)entity, pPos);
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new WorkplaceOfCorruptionBlockEntity(pPos, pState);
    }


}