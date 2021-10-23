/*     */ package com.rayanx.ambyss.block;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.rayanx.ambyss.AmbyssModElements;
/*     */ import com.rayanx.ambyss.AmbyssModElements.ModElement.Tag;
/*     */ import com.rayanx.ambyss.item.AmethystItem;
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
/*     */ import net.minecraft.util.Direction;
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
/*     */ public class AmethystOreBlock extends AmbyssModElements.ModElement {
/*     */   @ObjectHolder("ambyss:amethyst_ore")
/*  57 */   public static final Block block = null;
/*     */   public AmethystOreBlock(AmbyssModElements instance) {
/*  59 */     super(instance, 90);
/*  60 */     MinecraftForge.EVENT_BUS.register(this);
/*  61 */     FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  66 */     this.elements.blocks.add(() -> new CustomBlock());
/*  67 */     this.elements.items
/*  68 */       .add(() -> (Item)(new BlockItem(block, (new Item.Properties()).func_200916_a(CustomMaterialsItemGroup.tab))).setRegistryName(block.getRegistryName()));
/*     */   }
/*     */ 
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void clientLoad(FMLClientSetupEvent event) {
/*  74 */     RenderTypeLookup.setRenderLayer(block, RenderType.func_228641_d_());
/*     */   }
/*     */   
/*     */   public static class CustomBlock extends Block { public CustomBlock() {
/*  78 */       super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(12.0F, 12.0F).func_235838_a_(s -> 0).harvestLevel(5)
/*  79 */           .harvestTool(ToolType.PICKAXE).func_235861_h_());
/*  80 */       setRegistryName("amethyst_ore");
/*     */     }
/*     */     
/*     */     @OnlyIn(Dist.CLIENT)
/*     */     public boolean func_200122_a(BlockState state, BlockState adjacentBlockState, Direction side) {
/*  85 */       return (adjacentBlockState.func_177230_c() == this) ? true : super.func_200122_a(state, adjacentBlockState, side);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
/*  90 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
/*  95 */       return new ItemStack((IItemProvider)AmethystOreBlock.block, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<ItemStack> func_220076_a(BlockState state, LootContext.Builder builder) {
/* 100 */       List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
/* 101 */       if (!dropsOriginal.isEmpty())
/* 102 */         return dropsOriginal; 
/* 103 */       return Collections.singletonList(new ItemStack((IItemProvider)AmethystItem.block, 1));
/*     */     } }
/*     */   
/* 106 */   private static Feature<OreFeatureConfig> feature = null;
/* 107 */   private static ConfiguredFeature<?, ?> configuredFeature = null;
/* 108 */   private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH = null;
/*     */   
/* 110 */   private static class CustomRuleTest extends RuleTest { static final CustomRuleTest INSTANCE = new CustomRuleTest();
/* 111 */     static final Codec<CustomRuleTest> codec = Codec.unit(() -> INSTANCE);
/*     */     public boolean func_215181_a(BlockState blockAt, Random random) {
/* 113 */       boolean blockCriteria = false;
/* 114 */       if (blockAt.func_177230_c() == Blocks.field_150348_b.func_176223_P().func_177230_c())
/* 115 */         blockCriteria = true; 
/* 116 */       if (blockAt.func_177230_c() == Blocks.field_196650_c.func_176223_P().func_177230_c())
/* 117 */         blockCriteria = true; 
/* 118 */       if (blockAt.func_177230_c() == Blocks.field_196654_e.func_176223_P().func_177230_c())
/* 119 */         blockCriteria = true; 
/* 120 */       if (blockAt.func_177230_c() == Blocks.field_196654_e.func_176223_P().func_177230_c())
/* 121 */         blockCriteria = true; 
/* 122 */       if (blockAt.func_177230_c() == Blocks.field_196656_g.func_176223_P().func_177230_c())
/* 123 */         blockCriteria = true; 
/* 124 */       return blockCriteria;
/*     */     }
/*     */     
/*     */     protected IRuleTestType<?> func_215180_a() {
/* 128 */       return AmethystOreBlock.CUSTOM_MATCH;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class FeatureRegisterHandler {
/*     */     @SubscribeEvent
/*     */     public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
/* 135 */       AmethystOreBlock.CUSTOM_MATCH = (IRuleTestType)Registry.func_218322_a(Registry.field_218363_D, new ResourceLocation("ambyss:amethyst_ore_match"), () -> AmethystOreBlock.CustomRuleTest.codec);
/* 136 */       AmethystOreBlock.feature = (Feature<OreFeatureConfig>)new OreFeature(OreFeatureConfig.field_236566_a_)
/*     */         {
/*     */           public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
/* 139 */             RegistryKey<World> dimensionType = world.func_201672_e().func_234923_W_();
/* 140 */             boolean dimensionCriteria = false;
/* 141 */             if (dimensionType == World.field_234918_g_)
/* 142 */               dimensionCriteria = true; 
/* 143 */             if (!dimensionCriteria)
/* 144 */               return false; 
/* 145 */             return super.func_241855_a(world, generator, rand, pos, config);
/*     */           }
/*     */         };
/* 148 */       AmethystOreBlock.configuredFeature = (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)AmethystOreBlock.feature.func_225566_b_((IFeatureConfig)new OreFeatureConfig(AmethystOreBlock.CustomRuleTest.INSTANCE, AmethystOreBlock.block.func_176223_P(), 4)).func_242733_d(16))
/* 149 */         .func_242728_a()).func_242731_b(12);
/* 150 */       event.getRegistry().register(AmethystOreBlock.feature.setRegistryName("amethyst_ore"));
/* 151 */       Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("ambyss:amethyst_ore"), AmethystOreBlock.configuredFeature);
/*     */     }
/*     */     private FeatureRegisterHandler() {} }
/*     */   @SubscribeEvent
/*     */   public void addFeatureToBiomes(BiomeLoadingEvent event) {
/* 156 */     event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
/*     */   }
/*     */ }


/* Location:              D:\Webdev\Atlas Studios\rayanx.com\data\mods\ambyss.1.3.0.jar!\com\rayanx\ambyss\block\AmethystOreBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */