package be.ehb.demoresto.model;

import java.util.ArrayList;

public class MockRestoDataSource {
    private static final MockRestoDataSource ourInstance = new MockRestoDataSource();

    public static MockRestoDataSource getInstance() {
        return ourInstance;
    }

    private MockRestoDataSource() {
    }
    private ArrayList<Resto> restos = new ArrayList<>();

    public ArrayList<Resto> getRestos() {
        return restos;
    }
    public void addResto(Resto nResto){
        restos.add(nResto);
    }

}
