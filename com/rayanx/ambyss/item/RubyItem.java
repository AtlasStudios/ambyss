/*    */ package com.rayanx.ambyss.item;
/*    */ 
/*    */ import com.rayanx.ambyss.AmbyssModElements;
/*    */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*    */ import com.rayanx.ambyss.itemgroup.CustomMaterialsItemGroup;
/*    */ import net.minecraft.block.BlockState;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.Rarity;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class RubyItem
/*    */   extends AmbyssModElements.ModElement
/*    */ {
/*    */   @ObjectHolder("ambyss:ruby")
/* 17 */   public static final Item block = null;
/*    */   public RubyItem(AmbyssModElements instance) {
/* 19 */     super(instance, 19);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 24 */     this.elements.items.add(() -> new ItemCustom());
/*    */   }
/*    */   
/*    */   public static class ItemCustom extends Item { public ItemCustom() {
/* 28 */       super((new Item.Properties()).func_200916_a(CustomMaterialsItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.RARE));
/* 29 */       setRegistryName("ruby");
/*    */     }
/*    */ 
/*    */     
/*    */     public int func_77619_b() {
/* 34 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public int func_77626_a(ItemStack itemstack) {
/* 39 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
/* 44 */       return 1.0F;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\item\RubyItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */