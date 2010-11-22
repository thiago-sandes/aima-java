package aimax.osm.applications;

import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Logger;

import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.SimpleAgentApp;
import aimax.osm.data.DataResource;
import aimax.osm.data.MapDataStorage;
import aimax.osm.data.MapDataFactory;
import aimax.osm.reader.Bz2OsmReader;
import aimax.osm.reader.MapReader;
import aimax.osm.routing.agent.OsmAgentController;
import aimax.osm.routing.agent.OsmAgentFrame;
import aimax.osm.routing.agent.OsmAgentView;
import aimax.osm.routing.agent.OsmMapAdapter;

/**
 * Demonstrates, how the OSM map viewer can be integrated into a graphical
 * agent application.
 * @author Ruediger Lunde
 */
public class OsmAgentApp extends SimpleAgentApp {

	protected static Logger LOG = Logger.getLogger("aimax.osm");
	
	protected OsmMapAdapter map;
	
	/** Sets the default language (for file choosers etc.) to US. */
	public OsmAgentApp() {
		Locale.setDefault(Locale.US);
	}
	
	/** Reads a map from the specified stream and stores it in {@link #map}. */
	public void readMap(InputStream stream) {
		if (stream != null) {
			MapDataStorage mapData = MapDataFactory.instance().createMapDataStorage();
			MapReader mapReader = new Bz2OsmReader();
			mapReader.readMap(stream, mapData.getContentBuilder());
			map = new OsmMapAdapter(mapData);
		}
		else
			LOG.warning("Map reading failed because input stream does not exist.");
	}
	
	/** Reads a map from the specified file and stores it in {@link #map}. */
	public void readMap(File file) {
		MapDataStorage mapData = MapDataFactory.instance().createMapDataStorage();
		MapReader mapReader = new Bz2OsmReader();
		mapReader.readMap(file, mapData.getContentBuilder());
		map = new OsmMapAdapter(mapData);
	}
	
	/**
	 * Reads the default map showing the city of Ulm if no map
	 * has been loaded yet and calls the super class implementation.
	 */
	@Override
	public AgentAppFrame constructApplicationFrame() {
		if (map == null)
			readMap(DataResource.getULMFileResource());
		return super.constructApplicationFrame();
	}
	
	/** Factory method, which creates an <code>OsmAgentView</code>. */
	@Override
	public OsmAgentView createEnvironmentView() {
		return new OsmAgentView(map.getMapData());
	}

	/** Factory method, which creates an <code>OsmAgentFrame</code>. */
	@Override
	public AgentAppFrame createFrame() {
		return new OsmAgentFrame();
	}

	/** Factory method, which creates an <code>OsmAgentController</code>. */
	@Override
	public AgentAppController createController() {
		return new OsmAgentController(map);
	}

	
	/////////////////////////////////////////////////////////////////
	// starter method

	/**
	 * Application starter.
	 */
	public static void main(String args[]) {
		// Start with program arg -screenwidth=xx (with xx the width in cm).
		// Logger.getLogger("aimax.osm").setLevel(Level.FINEST);
		// Logger.getLogger("").getHandlers()[0].setLevel(Level.FINE);
		
		OsmAgentApp demo = new OsmAgentApp();
		// demo.readMap(new File("maps/Ulm.osm"));
		demo.startApplication();
	}
}