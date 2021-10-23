/*    */ package com.rayanx.ambyss.itemgroup;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.item.CryoiteItem;
/*    */ import net.minecraft.item.ItemGroup;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @Tag
/*    */ public class AmbyssWeaponsItemGroup
/*    */   extends AmbyssModElements.ModElement {
/*    */   public AmbyssWeaponsItemGroup(AmbyssModElements instance) {
/* 16 */     super(instance, 62);
/*    */   }
/*    */   public static ItemGroup tab;
/*    */   
/*    */   public void initElements() {
/* 21 */     tab = new ItemGroup("tabambyss_weapons")
/*    */       {
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public ItemStack func_78016_d() {
/* 25 */           return new ItemStack((IItemProvider)CryoiteItem.block, 1);
/*    */         }
/*    */         
/*    */         @OnlyIn(Dist.CLIENT)
/*    */         public boolean hasSearchBar() {
/* 30 */           return false;
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\itemgroup\AmbyssWeaponsItemGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */