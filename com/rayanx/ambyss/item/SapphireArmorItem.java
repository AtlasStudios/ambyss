/*     */ package com.rayanx.ambyss.item;
/*     */ 
/*     */ import com.rayanx.ambyss.AmbyssModElements;
/*     */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*     */ import com.rayanx.ambyss.itemgroup.CustomarmorItemGroup;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.inventory.EquipmentSlotType;
/*     */ import net.minecraft.item.ArmorItem;
/*     */ import net.minecraft.item.IArmorMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.Ingredient;
/*     */ import net.minecraft.util.IItemProvider;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.minecraftforge.registries.ObjectHolder;
/*     */ 
/*     */ @Tag
/*     */ public class SapphireArmorItem extends AmbyssModElements.ModElement {
/*     */   @ObjectHolder("ambyss:sapphire_armor_helmet")
/*  24 */   public static final Item helmet = null;
/*     */   @ObjectHolder("ambyss:sapphire_armor_chestplate")
/*  26 */   public static final Item body = null;
/*     */   @ObjectHolder("ambyss:sapphire_armor_leggings")
/*  28 */   public static final Item legs = null;
/*     */   @ObjectHolder("ambyss:sapphire_armor_boots")
/*  30 */   public static final Item boots = null;
/*     */   public SapphireArmorItem(AmbyssModElements instance) {
/*  32 */     super(instance, 83);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  37 */     IArmorMaterial armormaterial = new IArmorMaterial()
/*     */       {
/*     */         public int func_200896_a(EquipmentSlotType slot) {
/*  40 */           (new int[4])[0] = 13; (new int[4])[1] = 15; (new int[4])[2] = 16; (new int[4])[3] = 11; return (new int[4])[slot.func_188454_b()] * 1000;
/*     */         }
/*     */ 
/*     */         
/*     */         public int func_200902_b(EquipmentSlotType slot) {
/*  45 */           (new int[4])[0] = 20; (new int[4])[1] = 50; (new int[4])[2] = 60; (new int[4])[3] = 20; return (new int[4])[slot.func_188454_b()];
/*     */         }
/*     */ 
/*     */         
/*     */         public int func_200900_a() {
/*  50 */           return 9;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundEvent func_200899_b() {
/*  55 */           return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
/*     */         }
/*     */ 
/*     */         
/*     */         public Ingredient func_200898_c() {
/*  60 */           return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)SapphireItem.block, 1) });
/*     */         }
/*     */ 
/*     */         
/*     */         @OnlyIn(Dist.CLIENT)
/*     */         public String func_200897_d() {
/*  66 */           return "sapphire_armor";
/*     */         }
/*     */ 
/*     */         
/*     */         public float func_200901_e() {
/*  71 */           return 0.0F;
/*     */         }
/*     */ 
/*     */         
/*     */         public float func_230304_f_() {
/*  76 */           return 0.6F;
/*     */         }
/*     */       };
/*  79 */     this.elements.items.add(() -> (Item)(new ArmorItem(armormaterial, EquipmentSlotType.HEAD, (new Item.Properties()).func_200916_a(CustomarmorItemGroup.tab))
/*     */         {
/*     */           public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
/*  82 */             return "ambyss:textures/models/armor/sapphire__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
/*     */           }
/*     */         }).setRegistryName("sapphire_armor_helmet"));
/*  85 */     this.elements.items.add(() -> (Item)(new ArmorItem(armormaterial, EquipmentSlotType.CHEST, (new Item.Properties()).func_200916_a(CustomarmorItemGroup.tab))
/*     */         {
/*     */           public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
/*  88 */             return "ambyss:textures/models/armor/sapphire__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
/*     */           }
/*     */         }).setRegistryName("sapphire_armor_chestplate"));
/*  91 */     this.elements.items.add(() -> (Item)(new ArmorItem(armormaterial, EquipmentSlotType.LEGS, (new Item.Properties()).func_200916_a(CustomarmorItemGroup.tab))
/*     */         {
/*     */           public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
/*  94 */             return "ambyss:textures/models/armor/sapphire__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
/*     */           }
/*     */         }).setRegistryName("sapphire_armor_leggings"));
/*  97 */     this.elements.items.add(() -> (Item)(new ArmorItem(armormaterial, EquipmentSlotType.FEET, (new Item.Properties()).func_200916_a(CustomarmorItemGroup.tab))
/*     */         {
/*     */           public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
/* 100 */             return "ambyss:textures/models/armor/sapphire__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
/*     */           }
/*     */         }).setRegistryName("sapphire_armor_boots"));
/*     */   }
/*     */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\item\SapphireArmorItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */