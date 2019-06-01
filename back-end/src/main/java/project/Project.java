package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenbo on 1/4/18.
 */
public class Project {

    public Project() {
        mapInitialized = false;
    }

    // private variables
    private boolean mapInitialized = false;
    private Map<String, Canvas> canvasMap;
    private Map<String, Integer> canvasIdMap;
    private Map<String, View> viewMap;

    // JSON fields
    private String name;
    private ArrayList<View> views;
    private ArrayList<Canvas> canvases;
    private ArrayList<Jump> jumps;
    private String renderingParams;

    public String getName() {
        return name;
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public ArrayList<Canvas> getCanvases() {
        return canvases;
    }

    public ArrayList<Jump> getJumps() {
        return jumps;
    }

    public String getRenderingParams() {
        return renderingParams;
    }

    public Integer getCanvasNumId(String canvasId) {

        // safe to assume that they are already initialized?
        if (! mapInitialized) {
            mapInitialized = true;
            initializeMaps();
        }
        if (canvasIdMap.containsKey(canvasId))
            return canvasIdMap.get(canvasId);
        else
            return null;
    }

    public Canvas getCanvas(String canvasId) {

        if (! mapInitialized) {
            mapInitialized = true;
            initializeMaps();
        }
        if (canvasMap.containsKey(canvasId))
            return canvasMap.get(canvasId);
        else
            return null;
    }

    public View getView(String viewId) {

        if (! mapInitialized) {
            mapInitialized = true;
            initializeMaps();
        }
        if (viewMap.containsKey(viewId))
            return viewMap.get(viewId);
        else
            return null;
    }

    private void initializeMaps() {

        // initialize canvas map
        canvasMap = new HashMap<>();
        for (Canvas c : canvases)
            canvasMap.put(c.getId(), c);

        // initialize numeric canvas ids
        canvasIdMap = new HashMap<>();
        int canvasId = 0;
        for (Canvas c : canvases) {
            // can change this based on the separation we want between 3d rtrees 
            // or whatever else is affected by num ids
            canvasId += 1000000;
            canvasIdMap.put(c.getId(), canvasId);
        }

        // initialize view map
        viewMap = new HashMap<>();
        for (View v : views)
            viewMap.put(v.getId(), v);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", views=" + views +
                ", canvases=" + canvases +
                ", jumps=" + jumps +
                ", renderingParams='" + renderingParams + '\'' +
                '}';
    }
}
