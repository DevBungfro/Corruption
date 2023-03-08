package com.bungfro.corruption.client.screen.wpoc;

import com.bungfro.corruption.block.ModBlocks;
import com.bungfro.corruption.block.entity.ModBlockEntities;
import com.bungfro.corruption.block.entity.WorkplaceOfCorruptionBlockEntity;
import com.bungfro.corruption.client.screen.ModMenuTypes;
import com.bungfro.corruption.client.screen.renderer.FluidTankRenderer;
import com.bungfro.corruption.recipe.WorkplaceOfCorruptionRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fluids.FluidStack;

import java.util.Optional;

public class WorkplaceOfCorruptionMenu extends RecipeBookMenu<WorkplaceOfCorruptionContainer> {
    private final WorkplaceOfCorruptionContainer craftSlots = new WorkplaceOfCorruptionContainer(this, 5, 5);
    private final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;
    private final Level level;

    public final WorkplaceOfCorruptionBlockEntity blockEntity;

    private FluidStack fluidStack;

    public WorkplaceOfCorruptionMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL, pPlayerInventory.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public WorkplaceOfCorruptionMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess, BlockEntity entity) {
        super(ModMenuTypes.WORKPLACE_OF_CORRUPTION_MENU.get(), pContainerId);
        blockEntity = (WorkplaceOfCorruptionBlockEntity) entity;
        this.access = pAccess;
        this.player = pPlayerInventory.player;
        this.level = player.level;
        this.fluidStack = blockEntity.getFluidStack();
        this.addSlot(new WorkplaceOfCorruptionResultSlot(pPlayerInventory.player, this.craftSlots, this.resultSlots, 0, 146, 54));

        for(int j = 0; j < 5; ++j) {
            for(int k = 0; k < 5; ++k) {
                this.addSlot(new Slot(this.craftSlots, k + j * 5, 44 + k * 18, 18 + j * 18));
            }
        }


        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + 36));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(pPlayerInventory, i1, 8 + i1 * 18, 161 + 36));
        }

    }

    public void setFluid(FluidStack fluidStack) {
        this.fluidStack = fluidStack;
    }

    public FluidStack getFluidStack() {
        return fluidStack;
    }

    public WorkplaceOfCorruptionBlockEntity getBlockEntity() {
        return this.blockEntity;
    }

    protected static void slotChangedCraftingGrid(AbstractContainerMenu pMenu, Level pLevel, Player pPlayer, WorkplaceOfCorruptionContainer pContainer, ResultContainer pResult) {
        if (!pLevel.isClientSide) {
            ServerPlayer serverplayer = (ServerPlayer)pPlayer;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<WorkplaceOfCorruptionRecipe> optional = pLevel.getServer().getRecipeManager().getRecipeFor(WorkplaceOfCorruptionRecipe.Type.INSTANCE, pContainer, pLevel);
            if (optional.isPresent()) {
                WorkplaceOfCorruptionRecipe craftingrecipe = optional.get();
                if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                    ItemStack itemstack1 = craftingrecipe.assemble(pContainer);
                    if (itemstack1.isItemEnabled(pLevel.enabledFeatures())) {
                        itemstack = itemstack1;
                    }
                }
            }

            pResult.setItem(0, itemstack);
            pMenu.setRemoteSlot(0, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(pMenu.containerId, pMenu.incrementStateId(), 0, itemstack));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void slotsChanged(Container pInventory) {
        this.access.execute((p_39386_, p_39387_) -> {
            slotChangedCraftingGrid(this, p_39386_, this.player, this.craftSlots, this.resultSlots);
        });
    }

    public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
        this.craftSlots.fillStackedContents(pItemHelper);
    }

    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    @Override
    public boolean recipeMatches(Recipe<? super WorkplaceOfCorruptionContainer> pRecipe) {
        return pRecipe.matches(this.craftSlots, this.player.level);

    }

    /**
     * Called when the container is closed.
     */
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute((p_39371_, p_39372_) -> {
            this.clearContainer(pPlayer, this.craftSlots);
        });
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.WORKPLACE_OF_CORRUPTION.get());
    }


    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 0) {
                this.access.execute((p_39378_, p_39379_) -> {
                    itemstack1.getItem().onCraftedBy(itemstack1, p_39378_, pPlayer);
                });
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex >= 10 && pIndex < 46) {
                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
                    if (pIndex < 37) {
                        if (!this.moveItemStackTo(itemstack1, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemstack1, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
            if (pIndex == 0) {
                pPlayer.drop(itemstack1, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is
     * null for the initial slot that was double-clicked.
     */
    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public int getResultSlotIndex() {
        return 0;
    }

    public int getGridWidth() {
        return this.craftSlots.getWidth();
    }

    public int getGridHeight() {
        return this.craftSlots.getHeight();
    }

    public int getSize() {
        return 10;
    }

    public RecipeBookType getRecipeBookType() {
        return RecipeBookType.CRAFTING;
    }

    public boolean shouldMoveToInventory(int pSlotIndex) {
        return pSlotIndex != this.getResultSlotIndex();
    }
}
