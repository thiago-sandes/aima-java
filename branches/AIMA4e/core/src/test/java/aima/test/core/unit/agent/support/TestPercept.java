package aima.test.core.unit.agent.support;

import aima.core.api.agent.Percept;

/**
 * @author Ciaran O'Reilly
 */
public class TestPercept implements Percept {
    public final String location;
    public final boolean floorIsDirty;
    public TestPercept(String location, boolean floorIsDirty) {
        this.location     = location;
        this.floorIsDirty = floorIsDirty;
    }
}