/*    */ package com.rayanx.ambyss.itemgroup;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.item.RubyItem;
/*    */ import net.minecraft.item.ItemGroup;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @Tag
/*    */ public class CustomMaterialsItemGroup
/*    */   extends AmbyssModElements.ModElement {
/*    */   public CustomMaterialsItemGroup(AmbyssModElements instance) {
/* 16 */     super(instance, 2);
/*    */   }
/*    */   public static ItemGroup tab;
/*    */   
/*    */   public void initElements() {
/* 21 */     tab = new ItemGroup("tabcustom_materials")
/*    */       {
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public ItemStack func_78016_d() {
/* 25 */           return new ItemStack((IItemProvider)RubyItem.block, 1);
/*    */         }
/*    */         
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public boolean hasSearchBar() {
/* 30 */           return false;
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\itemgroup\CustomMaterialsItemGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */