/*    */ package com.rayanx.ambyss;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.entity.EntityType;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import net.minecraftforge.fml.network.NetworkRegistry;
/*    */ import net.minecraftforge.fml.network.simple.SimpleChannel;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod("ambyss")
/*    */ public class AmbyssMod
/*    */ {
/* 44 */   public static final Logger LOGGER = LogManager.getLogger(AmbyssMod.class);
/*    */   private static final String PROTOCOL_VERSION = "1";
/* 46 */   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("ambyss", "ambyss"), () -> "1", "1"::equals, "1"::equals);
/*    */   public AmbyssModElements elements;
/*    */   
/*    */   public AmbyssMod() {
/* 50 */     this.elements = new AmbyssModElements();
/* 51 */     FMLJavaModLoadingContext.get().getModEventBus().register(this);
/* 52 */     FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
/* 53 */     FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientLoad);
/* 54 */     MinecraftForge.EVENT_BUS.register(new AmbyssModFMLBusEvents(this));
/*    */   }
/*    */   
/*    */   private void init(FMLCommonSetupEvent event) {
/* 58 */     this.elements.getElements().forEach(element -> element.init(event));
/*    */   }
/*    */   
/*    */   public void clientLoad(FMLClientSetupEvent event) {
/* 62 */     this.elements.getElements().forEach(element -> element.clientLoad(event));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void registerBlocks(RegistryEvent.Register<Block> event) {
/* 67 */     event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getBlocks().stream().map(Supplier::get).toArray(x$0 -> new Block[x$0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void registerItems(RegistryEvent.Register<Item> event) {
/* 72 */     event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getItems().stream().map(Supplier::get).toArray(x$0 -> new Item[x$0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
/* 77 */     event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEntities().stream().map(Supplier::get).toArray(x$0 -> new EntityType[x$0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
/* 82 */     event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEnchantments().stream().map(Supplier::get).toArray(x$0 -> new Enchantment[x$0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
/* 87 */     this.elements.registerSounds(event);
/*    */   }
/*    */   
/*    */   private static class AmbyssModFMLBusEvents {
/*    */     AmbyssModFMLBusEvents(AmbyssMod parent) {
/* 92 */       this.parent = parent;
/*    */     }
/*    */     private final AmbyssMod parent;
/*    */     @SubscribeEvent
/*    */     public void serverLoad(FMLServerStartingEvent event) {
/* 97 */       this.parent.elements.getElements().forEach(element -> element.serverLoad(event));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\AmbyssMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */