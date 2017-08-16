
class Car {
	
	static int newSerial = 1; 
	protected double gewicht; 
	protected double laenge; 
	protected final int serial; //vom konstruktor festgelegt
	protected Car nextCar = null; 
	
	Car(double gewicht, double laenge)
	{
		this.gewicht = gewicht; 
		this.laenge = laenge; 
		this.serial = newSerial; 
		newSerial++;
	}
	
	public String toString()
	{
		String str =  "serial: " + this.serial + " gewicht: " + this.gewicht + " laenge: " + this.laenge;
		return str; 
	}
	
	void connectTo(Car newCar)
	{
		newCar.nextCar = this; 
	}
	
	Car next()
	{
		return this.nextCar; 
	}
}
