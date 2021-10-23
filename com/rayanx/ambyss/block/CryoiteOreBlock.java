/*     */ package com.rayanx.ambyss.block;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.rayanx.ambyss.AmbyssModElements;
/*     */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*     */ import com.rayanx.ambyss.item.CryoiteItem;
/*     */ import com.rayanx.ambyss.itemgroup.CustomMaterialsItemGroup;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.AbstractBlock;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockState;
/*     */ import net.minecraft.block.Blocks;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.RenderTypeLookup;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.item.BlockItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.loot.LootContext;
/*     */ import net.minecraft.util.IItemProvider;
/*     */ import net.minecraft.util.RegistryKey;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.registry.Registry;
/*     */ import net.minecraft.util.registry.WorldGenRegistries;
/*     */ import net.minecraft.world.IBlockReader;
/*     */ import net.minecraft.world.ISeedReader;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.ChunkGenerator;
/*     */ import net.minecraft.world.gen.GenerationStage;
/*     */ import net.minecraft.world.gen.feature.ConfiguredFeature;
/*     */ import net.minecraft.world.gen.feature.Feature;
/*     */ import net.minecraft.world.gen.feature.IFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.OreFeature;
/*     */ import net.minecraft.world.gen.feature.OreFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.template.IRuleTestType;
/*     */ import net.minecraft.world.gen.feature.template.RuleTest;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.ToolType;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.event.world.BiomeLoadingEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*     */ import net.minecraftforge.registries.ObjectHolder;
/*     */ 
/*     */ @Tag
/*     */ public class CryoiteOreBlock extends AmbyssModElements.ModElement {
/*     */   @ObjectHolder("ambyss:cryoite_ore")
/*  56 */   public static final Block block = null;
/*     */   public CryoiteOreBlock(AmbyssModElements instance) {
/*  58 */     super(instance, 92);
/*  59 */     MinecraftForge.EVENT_BUS.register(this);
/*  60 */     FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  65 */     this.elements.blocks.add(() -> new CustomBlock());
/*  66 */     this.elements.items
/*  67 */       .add(() -> (Item)(new BlockItem(block, (new Item.Properties()).func_200916_a(CustomMaterialsItemGroup.tab))).setRegistryName(block.getRegistryName()));
/*     */   }
/*     */ 
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void clientLoad(FMLClientSetupEvent event) {
/*  73 */     RenderTypeLookup.setRenderLayer(block, RenderType.func_228641_d_());
/*     */   }
/*     */   
/*     */   public static class CustomBlock extends Block { public CustomBlock() {
/*  77 */       super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(16.0F, 16.0F).func_235838_a_(s -> 0).harvestLevel(7)
/*  78 */           .harvestTool(ToolType.PICKAXE).func_235861_h_().func_226896_b_().func_235828_a_((bs, br, bp) -> false));
/*  79 */       setRegistryName("cryoite_ore");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
/*  84 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
/*  89 */       return new ItemStack((IItemProvider)CryoiteOreBlock.block, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<ItemStack> func_220076_a(BlockState state, LootContext.Builder builder) {
/*  94 */       List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
/*  95 */       if (!dropsOriginal.isEmpty())
/*  96 */         return dropsOriginal; 
/*  97 */       return Collections.singletonList(new ItemStack((IItemProvider)CryoiteItem.block, 1));
/*     */     } }
/*     */   
/* 100 */   private static Feature<OreFeatureConfig> feature = null;
/* 101 */   private static ConfiguredFeature<?, ?> configuredFeature = null;
/* 102 */   private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH = null;
/*     */   
/* 104 */   private static class CustomRuleTest extends RuleTest { static final CustomRuleTest INSTANCE = new CustomRuleTest();
/* 105 */     static final Codec<CustomRuleTest> codec = Codec.unit(() -> INSTANCE);
/*     */     public boolean func_215181_a(BlockState blockAt, Random random) {
/* 107 */       boolean blockCriteria = false;
/* 108 */       if (blockAt.func_177230_c() == Blocks.field_150348_b.func_176223_P().func_177230_c())
/* 109 */         blockCriteria = true; 
/* 110 */       if (blockAt.func_177230_c() == Blocks.field_196650_c.func_176223_P().func_177230_c())
/* 111 */         blockCriteria = true; 
/* 112 */       if (blockAt.func_177230_c() == Blocks.field_196654_e.func_176223_P().func_177230_c())
/* 113 */         blockCriteria = true; 
/* 114 */       if (blockAt.func_177230_c() == Blocks.field_196654_e.func_176223_P().func_177230_c())
/* 115 */         blockCriteria = true; 
/* 116 */       if (blockAt.func_177230_c() == Blocks.field_196656_g.func_176223_P().func_177230_c())
/* 117 */         blockCriteria = true; 
/* 118 */       return blockCriteria;
/*     */     }
/*     */     
/*     */     protected IRuleTestType<?> func_215180_a() {
/* 122 */       return CryoiteOreBlock.CUSTOM_MATCH;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class FeatureRegisterHandler {
/*     */     @SubscribeEvent
/*     */     public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
/* 129 */       CryoiteOreBlock.CUSTOM_MATCH = (IRuleTestType)Registry.func_218322_a(Registry.field_218363_D, new ResourceLocation("ambyss:cryoite_ore_match"), () -> CryoiteOreBlock.CustomRuleTest.codec);
/* 130 */       CryoiteOreBlock.feature = (Feature<OreFeatureConfig>)new OreFeature(OreFeatureConfig.field_236566_a_)
/*     */         {
/*     */           public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
/* 133 */             RegistryKey<World> dimensionType = world.func_201672_e().func_234923_W_();
/* 134 */             boolean dimensionCriteria = false;
/* 135 */             if (dimensionType == World.field_234918_g_)
/* 136 */               dimensionCriteria = true; 
/* 137 */             if (!dimensionCriteria)
/* 138 */               return false; 
/* 139 */             return super.func_241855_a(world, generator, rand, pos, config);
/*     */           }
/*     */         };
/* 142 */       CryoiteOreBlock.configuredFeature = (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)CryoiteOreBlock.feature.func_225566_b_((IFeatureConfig)new OreFeatureConfig(CryoiteOreBlock.CustomRuleTest.INSTANCE, CryoiteOreBlock.block.func_176223_P(), 4)).func_242733_d(16))
/* 143 */         .func_242728_a()).func_242731_b(12);
/* 144 */       event.getRegistry().register(CryoiteOreBlock.feature.setRegistryName("cryoite_ore"));
/* 145 */       Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("ambyss:cryoite_ore"), CryoiteOreBlock.configuredFeature);
/*     */     }
/*     */     private FeatureRegisterHandler() {} }
/*     */   @SubscribeEvent
/*     */   public void addFeatureToBiomes(BiomeLoadingEvent event) {
/* 150 */     event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
/*     */   }
/*     */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\block\CryoiteOreBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */