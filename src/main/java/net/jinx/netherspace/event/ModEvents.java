package net.jinx.netherspace.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.item.ModItems;
import net.jinx.netherspace.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = NetherSpace.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void  addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.SKITTLE.get(), 4),
                    64, 100, 0.02f));

            // level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.BREAD, 6),
                    new ItemStack(ModItems.SKITTLE.get(), 4),
                    64, 100, 0.02f));
        }

        if (event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 3));

            // level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    enchantedBook,
                    2, 8, 0.02f));

        }

        if (event.getType() == ModVillagers.DRAGONMANCER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SKITTLE.get(), 12),
                    new ItemStack(ModItems.MTG_SWAMP.get(), 2),
                    2, 8, 0.02f));

            //level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHER_INGOT.get(), 1),
                    new ItemStack(Items.ELYTRA, 1),
                    1, 16, 0.02f));

            //level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64),
                    new ItemStack(Items.DRAGON_EGG, 1),
                    4, 32, 0.02f));

            //level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.NETHERITE_INGOT, 16),
                    new ItemStack(Items.DRAGON_HEAD, 1),
                    16, 64, 0.02f));

            //level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHER_INGOT.get(), 16),
                    new ItemStack(Items.END_PORTAL_FRAME, 1),
                    3, 128, 0.02f));

        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 32),
                new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                1, 64, 3));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 64),
                new ItemStack(ModItems.NETHER_INGOT.get(), 1),
                1, 64, 4));
    }

}
