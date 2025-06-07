package net.jinx.netherspace;

import com.mojang.logging.LogUtils;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.block.entity.ModBlockEntities;
import net.jinx.netherspace.entity.ModEntities;
import net.jinx.netherspace.entity.client.ModBoatRenderer;
import net.jinx.netherspace.entity.client.RhinoRenderer;
import net.jinx.netherspace.entity.custom.ModChestBoatEntity;
import net.jinx.netherspace.item.ModCreativeModeTabs;
import net.jinx.netherspace.item.ModItems;
import net.jinx.netherspace.loot.ModLootModifiers;
import net.jinx.netherspace.recipe.ModRecipes;
import net.jinx.netherspace.screen.GemPolishingStationScreen;
import net.jinx.netherspace.screen.ModMenuTypes;
import net.jinx.netherspace.sound.ModSounds;
import net.jinx.netherspace.util.ModWoodTypes;
import net.jinx.netherspace.villager.ModVillagers;
import net.jinx.netherspace.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.swing.text.html.parser.Entity;

@Mod(NetherSpace.MOD_ID)
public class NetherSpace {
    public static final String MOD_ID = "netherspace";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NetherSpace() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModTrunkPlacerTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.NETHER_INGOT);
            event.accept(ModItems.RAW_NETHER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.NETHERW);

            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        }
    }
}
