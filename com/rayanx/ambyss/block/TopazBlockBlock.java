/*    */ package com.rayanx.ambyss.block;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.itemgroup.CustomMaterialsItemGroup;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.AbstractBlock;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockState;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.RenderTypeLookup;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.item.BlockItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.loot.LootContext;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.RayTraceResult;
/*    */ import net.minecraft.world.IBlockReader;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import net.minecraftforge.common.ToolType;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class TopazBlockBlock
/*    */   extends AmbyssModElements.ModElement {
/*    */   @ObjectHolder("ambyss:topaz_block")
/* 34 */   public static final Block block = null;
/*    */   public TopazBlockBlock(AmbyssModElements instance) {
/* 36 */     super(instance, 96);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 41 */     this.elements.blocks.add(() -> new CustomBlock());
/* 42 */     this.elements.items
/* 43 */       .add(() -> (Item)(new BlockItem(block, (new Item.Properties()).func_200916_a(CustomMaterialsItemGroup.tab))).setRegistryName(block.getRegistryName()));
/*    */   }
/*    */ 
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public void clientLoad(FMLClientSetupEvent event) {
/* 49 */     RenderTypeLookup.setRenderLayer(block, RenderType.func_228641_d_());
/*    */   }
/*    */   
/*    */   public static class CustomBlock extends Block { public CustomBlock() {
/* 53 */       super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(1.0F, 10.0F).func_235838_a_(s -> 0).harvestLevel(6)
/* 54 */           .harvestTool(ToolType.PICKAXE).func_235861_h_().func_226896_b_().func_235828_a_((bs, br, bp) -> false));
/* 55 */       setRegistryName("topaz_block");
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
/* 60 */       return true;
/*    */     }
/*    */ 
/*    */     
/*    */     public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
/* 65 */       return new ItemStack((IItemProvider)TopazBlockBlock.block, 1);
/*    */     }
/*    */ 
/*    */     
/*    */     public List<ItemStack> func_220076_a(BlockState state, LootContext.Builder builder) {
/* 70 */       List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
/* 71 */       if (!dropsOriginal.isEmpty())
/* 72 */         return dropsOriginal; 
/* 73 */       return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\block\TopazBlockBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */