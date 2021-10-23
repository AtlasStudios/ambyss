/*    */ package com.rayanx.ambyss.item;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.itemgroup.CustomtoolsItemGroup;
/*    */ import net.minecraft.item.IItemTier;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.PickaxeItem;
/*    */ import net.minecraft.item.crafting.Ingredient;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class TopazPickaxeItem
/*    */   extends AmbyssModElements.ModElement
/*    */ {
/*    */   @ObjectHolder("ambyss:topaz_pickaxe")
/* 17 */   public static final Item block = null;
/*    */   public TopazPickaxeItem(AmbyssModElements instance) {
/* 19 */     super(instance, 28);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 24 */     this.elements.items.add(() -> (Item)(new PickaxeItem(new IItemTier() {
/*    */             public int func_200926_a() {
/* 26 */               return 16248;
/*    */             }
/*    */             
/*    */             public float func_200928_b() {
/* 30 */               return 18.0F;
/*    */             }
/*    */             
/*    */             public float func_200929_c() {
/* 34 */               return 8.0F;
/*    */             }
/*    */             
/*    */             public int func_200925_d() {
/* 38 */               return 4;
/*    */             }
/*    */             
/*    */             public int func_200927_e() {
/* 42 */               return 32;
/*    */             }
/*    */             
/*    */             public Ingredient func_200924_f() {
/* 46 */               return Ingredient.field_193370_a;
/*    */             }
/*    */           },  1, -3.0F, (new Item.Properties()).func_200916_a(CustomtoolsItemGroup.tab)) {
/*    */         
/*    */         }).setRegistryName("topaz_pickaxe"));
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\item\TopazPickaxeItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */