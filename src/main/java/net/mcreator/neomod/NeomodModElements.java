/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.mcreator.neomod;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class NeomodModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public NeomodModElements() {
		sounds.put(new ResourceLocation("neomod", "g36c"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "g36c")));
		sounds.put(new ResourceLocation("neomod", "magnum"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "magnum")));
		sounds.put(new ResourceLocation("neomod", "sova90"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "sova90")));
		sounds.put(new ResourceLocation("neomod", "hkusp"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "hkusp")));
		sounds.put(new ResourceLocation("neomod", "rg"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "rg")));
		sounds.put(new ResourceLocation("neomod", "ab"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "ab")));
		sounds.put(new ResourceLocation("neomod", "cb"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "cb")));
		sounds.put(new ResourceLocation("neomod", "kar48k"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "kar48k")));
		sounds.put(new ResourceLocation("neomod", "ak47"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "ak47")));
		sounds.put(new ResourceLocation("neomod", "phgun"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "phgun")));
		sounds.put(new ResourceLocation("neomod", "usp_s"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "usp_s")));
		sounds.put(new ResourceLocation("neomod", "m4_s"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "m4_s")));
		sounds.put(new ResourceLocation("neomod", "m4"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "m4")));
		sounds.put(new ResourceLocation("neomod", "silencer"), new net.minecraft.util.SoundEvent(new ResourceLocation("neomod", "silencer")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("neomod").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == NeomodModElements.ModElement.class)
						elements.add((NeomodModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(NeomodModElements.ModElement::initElements);
		this.addNetworkMessage(NeomodModVariables.WorldSavedDataSyncMessage.class, NeomodModVariables.WorldSavedDataSyncMessage::buffer,
				NeomodModVariables.WorldSavedDataSyncMessage::new, NeomodModVariables.WorldSavedDataSyncMessage::handler);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData mapdata = NeomodModVariables.MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = NeomodModVariables.WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				NeomodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new NeomodModVariables.WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				NeomodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new NeomodModVariables.WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData worlddata = NeomodModVariables.WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				NeomodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new NeomodModVariables.WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	private int messageID = 0;
	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		NeomodMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<Biome>> getBiomes() {
		return biomes;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final NeomodModElements elements;
		protected final int sortid;
		public ModElement(NeomodModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
