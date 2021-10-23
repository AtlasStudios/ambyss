/*    */ package com.rayanx.ambyss.item;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.itemgroup.CustomtoolsItemGroup;
/*    */ import net.minecraft.item.IItemTier;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ShovelItem;
/*    */ import net.minecraft.item.crafting.Ingredient;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class AmethystShovelItem
/*    */   extends AmbyssModElements.ModElement {
/*    */   @ObjectHolder("ambyss:amethyst_shovel")
/* 18 */   public static final Item block = null;
/*    */   public AmethystShovelItem(AmbyssModElements instance) {
/* 20 */     super(instance, 16);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 25 */     this.elements.items.add(() -> (Item)(new ShovelItem(new IItemTier() {
/*    */             public int func_200926_a() {
/* 27 */               return 8124;
/*    */             }
/*    */             
/*    */             public float func_200928_b() {
/* 31 */               return 14.0F;
/*    */             }
/*    */             
/*    */             public float func_200929_c() {
/* 35 */               return 8.0F;
/*    */             }
/*    */             
/*    */             public int func_200925_d() {
/* 39 */               return 5;
/*    */             }
/*    */             
/*    */             public int func_200927_e() {
/* 43 */               return 30;
/*    */             }
/*    */             
/*    */             public Ingredient func_200924_f() {
/* 47 */               return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)AmethystItem.block, 1) });
/*    */             }
/*    */           }1.0F, -3.0F, (new Item.Properties()).func_200916_a(CustomtoolsItemGroup.tab).func_234689_a_()) {
/*    */         
/*    */         }).setRegistryName("amethyst_shovel"));
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\item\AmethystShovelItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */