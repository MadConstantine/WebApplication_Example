package ru.constantine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ru.constantine.entities.*;

public class Model {
	private static Model instance = new Model();
	private List<Parcel> parcels;
	
	private Model() {
		parcels = new LinkedList<Parcel>();
	}
	
	public static Model getInstance() {
		return instance;
	}
	
	public synchronized void add(Parcel parcel) {
		parcel.setId(parcels.size());
		parcels.add(parcel);
	}
	
	public List<Parcel> list() {
		return parcels;
	}
}
