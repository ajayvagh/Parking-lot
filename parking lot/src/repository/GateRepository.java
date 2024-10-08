package repository;

import exception.GateNotFoundException;
import models.Gate;

import java.util.HashMap;

public class GateRepository {
    private HashMap < Integer, Gate > gateMap;

    public GateRepository() {
        this.gateMap = new HashMap <> ();
    }

    public Gate get(int gateId) throws GateNotFoundException {
        Gate gate = gateMap.get(gateId);
        if(gate == null) {
            throw new GateNotFoundException("Gate not found for Id : " + gateId);
        }
        return gate;
    }

    public Gate put(Gate gate) {
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}

// private static int gateIdCounter;
//  gateIdCounter = 0;
//  gate.setId(++gateIdCounter);
//commented bcz repo layer should not have business logic only CRUD logic