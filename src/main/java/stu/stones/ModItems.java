package stu.stones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Function;

public class ModItems {
    public static final Item THUNDERSTONE = registerItem("thunderstone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item FIRESTONE = registerItem("firestone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item WATERSTONE = registerItem("waterstone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item WINDSTONE = registerItem("windstone", Item::new,  new Item.Settings().maxCount(64));


    public static final Item THUNDERSTAFF =  registerItem("thunderstaff",ThunderStaffItem::new, new Item.Settings().maxDamage(32));
    public static final Item FIRESTAFF =  registerItem("firestaff",FireStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Item WATERSTAFF =  registerItem("waterstaff",WaterStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Item WINDSTAFF =  registerItem("windstaff",WindStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Item COPPERSWORD =  registerItem("coppersword",settings -> new SwordItem(ToolMaterial.IRON, 3, -2.4f, settings), new Item.Settings().maxDamage(32));
    public static final Item COPPERPICKAXE=  registerItem("copperpickaxe",settings -> new PickaxeItem(ToolMaterial.IRON, 1, -2.8f, settings), new Item.Settings().maxDamage(32));
    public static final Item COPPERAXE=  registerItem("copperaxe",settings -> new AxeItem(ToolMaterial.IRON, 4, -3.2f, settings), new Item.Settings().maxDamage(32));
    public static final Item COPPERSHOVEL=  registerItem("coppershovel",settings -> new ShovelItem(ToolMaterial.IRON, 1, -2.8f, settings), new Item.Settings().maxDamage(32));

    public static final Block THUNDERORE = registerBlock("thunderore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block FIREORE = registerBlock("fireore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block WATERORE = registerBlock("waterore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block WINDORE = registerBlock("windore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());

    public static final Item CUSTOMZOMBIESPAWNEGG = registerItem("customzombiespawnegg", settings -> new SpawnEggItem(),  new Item.Settings());
    
    public static final RegistryKey<PlacedFeature> CUSTOMTHUNDERORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("stones","customthunderore"));
    public static final RegistryKey<PlacedFeature> CUSTOMFIREORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("stones","customfireore"));
    public static final RegistryKey<PlacedFeature> CUSTOMWATERORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("stones","customwaterore"));
    public static final RegistryKey<PlacedFeature> CUSTOMWINDORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("stones","customwindore"));


    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stones",name));
        return Items.register(registerKey,factory,settings);
    }

    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings){
        final RegistryKey<Block> registerKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("stones",name));
        Block freshBlock = Blocks.register(registerKey,factory,settings);
        Items.register(freshBlock);
        return freshBlock;
    }

    private static void customIngredientsNatural(FabricItemGroupEntries entries){
        entries.add(THUNDERSTONE);
        entries.add(FIRESTONE);
        entries.add(WATERSTONE);
        entries.add(WINDSTONE);
        entries.add(THUNDERORE);
        entries.add(FIREORE);
        entries.add(WATERORE);
        entries.add(WINDORE);
    }

    private static void customIngredientsCombat(FabricItemGroupEntries entries){
        entries.add(THUNDERSTAFF);
        entries.add(FIRESTAFF);
        entries.add(WATERSTAFF);
        entries.add(WINDSTAFF);
        entries.add(COPPERSWORD);
        entries.add(COPPERPICKAXE);
        entries.add(COPPERAXE);
        entries.add(COPPERSHOVEL);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customIngredientsNatural);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::customIngredientsCombat);
    }



}
