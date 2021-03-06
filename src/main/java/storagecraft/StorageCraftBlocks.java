package storagecraft;

import storagecraft.block.BlockCable;
import storagecraft.block.BlockConstructor;
import storagecraft.block.BlockController;
import storagecraft.block.BlockDestructor;
import storagecraft.block.BlockDetector;
import storagecraft.block.BlockDrive;
import storagecraft.block.BlockExporter;
import storagecraft.block.BlockGrid;
import storagecraft.block.BlockImporter;
import storagecraft.block.BlockMachineCasing;
import storagecraft.block.BlockSolderer;
import storagecraft.block.BlockExternalStorage;
import storagecraft.block.BlockWirelessTransmitter;

public final class StorageCraftBlocks
{
	public static final BlockController CONTROLLER = new BlockController();
	public static final BlockCable CABLE = new BlockCable();
	public static final BlockGrid GRID = new BlockGrid();
	public static final BlockDrive DRIVE = new BlockDrive();
	public static final BlockExternalStorage EXTERNAL_STORAGE = new BlockExternalStorage();
	public static final BlockImporter IMPORTER = new BlockImporter();
	public static final BlockExporter EXPORTER = new BlockExporter();
	public static final BlockDetector DETECTOR = new BlockDetector();
	public static final BlockMachineCasing MACHINE_CASING = new BlockMachineCasing();
	public static final BlockSolderer SOLDERER = new BlockSolderer();
	public static final BlockWirelessTransmitter WIRELESS_TRANSMITTER = new BlockWirelessTransmitter();
	public static final BlockDestructor DESTRUCTOR = new BlockDestructor();
	public static final BlockConstructor CONSTRUCTOR = new BlockConstructor();
}
