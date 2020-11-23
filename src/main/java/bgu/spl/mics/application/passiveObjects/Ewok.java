package bgu.spl.mics.application.passiveObjects;

/**
 * Passive data-object representing a forest creature summoned when HanSolo and C3PO receive AttackEvents.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You may add fields and methods to this class as you see fit (including public methods).
 */
public class Ewok {
	int serialNumber;
	boolean available;
	public Ewok(int serialNumber , boolean available){
	    this.serialNumber = serialNumber;
	    this.available = available;
    }
  
    /**
     * Acquires an Ewok
     */
    public void acquire() {
		
    }

    /**
     * release an Ewok
     */
    public void release() {
    	
    }
    public int getSerialNumber(){
        return this.serialNumber;
    }
    public boolean getAvailable(){
        return this.available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
    public void setSerialNumber(int serialNumber){
        this.serialNumber =serialNumber;
    }

}
