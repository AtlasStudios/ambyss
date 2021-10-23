/*     */ package com.rayanx.ambyss;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.network.NetworkEvent;
/*     */ import net.minecraftforge.forgespi.language.ModFileScanData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AmbyssModElements
/*     */ {
/*  41 */   public final List<ModElement> elements = new ArrayList<>();
/*  42 */   public final List<Supplier<Block>> blocks = new ArrayList<>();
/*  43 */   public final List<Supplier<Item>> items = new ArrayList<>();
/*  44 */   public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
/*  45 */   public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
/*  46 */   public static Map<ResourceLocation, SoundEvent> sounds = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int messageID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
/*  66 */     for (Map.Entry<ResourceLocation, SoundEvent> sound : sounds.entrySet())
/*  67 */       event.getRegistry().register(((SoundEvent)sound.getValue()).setRegistryName(sound.getKey())); 
/*     */   }
/*  69 */   public AmbyssModElements() { this.messageID = 0; try { ModFileScanData modFileInfo = ModList.get().getModFileById("ambyss").getFile().getScanResult(); Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations(); for (ModFileScanData.AnnotationData annotationData : annotations) { if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) { Class<?> clazz = Class.forName(annotationData.getClassType().getClassName()); if (clazz.getSuperclass() == ModElement.class)
/*     */             this.elements.add(clazz.getConstructor(new Class[] { getClass() }).newInstance(new Object[] { this }));  }  }  }
/*     */     catch (Exception e) { e.printStackTrace(); }
/*  72 */      Collections.sort(this.elements); this.elements.forEach(ModElement::initElements); } public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) { AmbyssMod.PACKET_HANDLER.registerMessage(this.messageID, messageType, encoder, decoder, messageConsumer);
/*  73 */     this.messageID++; }
/*     */ 
/*     */   
/*     */   public List<ModElement> getElements() {
/*  77 */     return this.elements;
/*     */   }
/*     */   
/*     */   public List<Supplier<Block>> getBlocks() {
/*  81 */     return this.blocks;
/*     */   }
/*     */   
/*     */   public List<Supplier<Item>> getItems() {
/*  85 */     return this.items;
/*     */   }
/*     */   
/*     */   public List<Supplier<EntityType<?>>> getEntities() {
/*  89 */     return this.entities;
/*     */   }
/*     */   
/*     */   public List<Supplier<Enchantment>> getEnchantments() {
/*  93 */     return this.enchantments;
/*     */   }
/*     */   
/*     */   public static class ModElement
/*     */     implements Comparable<ModElement> {
/*     */     protected final AmbyssModElements elements;
/*     */     protected final int sortid;
/*     */     
/*     */     public ModElement(AmbyssModElements elements, int sortid) {
/* 102 */       this.elements = elements;
/* 103 */       this.sortid = sortid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initElements() {}
/*     */ 
/*     */     
/*     */     public void init(FMLCommonSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public void serverLoad(FMLServerStartingEvent event) {}
/*     */ 
/*     */     
/*     */     @OnlyIn(Dist.CLIENT)
/*     */     public void clientLoad(FMLClientSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public int compareTo(ModElement other) {
/* 121 */       return this.sortid - other.sortid;
/*     */     }
/*     */     
/*     */     @Retention(RetentionPolicy.RUNTIME)
/*     */     public static @interface Tag {}
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Tag {}
/*     */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\AmbyssModElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */