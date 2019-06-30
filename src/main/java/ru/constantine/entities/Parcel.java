package ru.constantine.entities;

/**
 * Represents a post issue: a package, letter, or something.
 * It can be a LETTER, PACKAGE, WRAPPER or POSTCARD.
 * @author Constantine
 * @date 21/06/2019
 */
public class Parcel {
	/**
	 * Different types of a parcel
	 */
	public enum ParcelType {
		LETTER,PACKAGE,WRAPPER,POSTCARD;
	}
	
	/**
	 * Parcel id
	 */
	private long id;
	
	/**
	 * Parcel type, can be LETTER, PACKAGE, WRAPPER or POSTCARD
	 */
	private ParcelType type;
	
	/**
	 * Post index of receiver of particular parcel
	 */
	private String receiverIndex;
	
	/**
	 * Receiver`s address
	 */
	private String receiverAdr;
	
	/**
	 * Receiver`s name
	 */
	private String receiverName;
	
	/**
	 * Default constructor
	 */
	public Parcel() {
		
	}
	
	/**
	 * Constructor, that initializes all fields of Parcel
	 * @param id
	 * @param type
	 * @param receiverIndex
	 * @param receiverAdr
	 * @param receiverName
	 */
	public Parcel(ParcelType type, String receiverIndex, String receiverAdr, String receiverName) {
		this.type = type;
		this.receiverIndex = receiverIndex;
		this.receiverAdr = receiverAdr;
		this.receiverName = receiverName;
	}
	
	public long getId() {
		return id;
	}
	public ParcelType getType() {
		return type;
	}
	public String getReceiverIndex() {
		return receiverIndex;
	}
	public String getReceiverAdr() {
		return receiverAdr;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setType(ParcelType type) {
		this.type = type;
	}
	public void setReceiverIndex(String receiverIndex) {
		this.receiverIndex = receiverIndex;
	}
	public void setReceiverAdr(String receiverAdr) {
		this.receiverAdr = receiverAdr;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Override
	public String toString() {
		return "Parcel [id=" + id + ", type=" + type + ", receiverIndex=" + receiverIndex + ", receiverAdr="
				+ receiverAdr + ", receiverName=" + receiverName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		
		Parcel parcel = (Parcel) obj;
		boolean isRecvAdr = this.receiverAdr != null ? this.receiverAdr.equalsIgnoreCase(parcel.receiverAdr) : parcel.receiverAdr == null;
		boolean isRecvName = this.receiverName != null ? this.receiverName.equalsIgnoreCase(parcel.receiverName) : parcel.receiverName == null;
		boolean isRecvInd = this.receiverIndex != null ? this.receiverIndex.equalsIgnoreCase(parcel.receiverIndex) : parcel.receiverIndex == null;
		if (this.id == parcel.id && this.type.equals(parcel.type) && isRecvInd &&
			isRecvAdr && isRecvName) {return true;}
		else {return false;}
	}
	
	@Override
	public int hashCode() {
		int hash;
		int recvAdrHash = this.receiverAdr != null ? this.receiverAdr.hashCode() : 0;
		int recvNameHash = this.receiverName != null ? this.receiverName.hashCode() : 0;
		int recvIndHash = this.receiverIndex != null ? this.receiverIndex.hashCode() : 0;
		hash = Long.hashCode(this.id) + recvIndHash + recvAdrHash + recvNameHash;
		return hash;
	}
}
