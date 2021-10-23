/*    */ package com.rayanx.ambyss.itemgroup;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import net.minecraft.item.ItemGroup;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.Items;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @Tag
/*    */ public class CustomtoolsItemGroup
/*    */   extends AmbyssModElements.ModElement {
/*    */   public CustomtoolsItemGroup(AmbyssModElements instance) {
/* 16 */     super(instance, 3);
/*    */   }
/*    */   public static ItemGroup tab;
/*    */   
/*    */   public void initElements() {
/* 21 */     tab = new ItemGroup("tabcustomtools")
/*    */       {
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public ItemStack func_78016_d() {
/* 25 */           return new ItemStack((IItemProvider)Items.field_185158_cP, 1);
/*    */         }
/*    */         
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public boolean hasSearchBar() {
/* 30 */           return false;
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\itemgroup\CustomtoolsItemGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */