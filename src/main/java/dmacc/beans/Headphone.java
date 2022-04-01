package dmacc.beans;

import javax.persistence.*;

@Entity
@Table(name="headphones")
public class Headphone {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="weight")
	private int weightInGrams;
	@Column(name="driver")
	private String driverType;
	@Column(name="impedance")
	private int impedance;
	
	public Headphone() {
		super();
		this.driverType = "planar";
		// TODO Auto-generated constructor stub
	}

	public Headphone(String name) {
		super();
		this.name = name;
	}

	public Headphone(String name, int weightInGrams, String driverType, int impedance) {
		super();
		this.name = name;
		this.weightInGrams = weightInGrams;
		this.driverType = driverType;
		this.impedance = impedance;
	}
	
	public Headphone(int id, String name, int weightInGrams, String driverType, int impedance) {
		super();
		this.id = id;
		this.name = name;
		this.weightInGrams = weightInGrams;
		this.driverType = driverType;
		this.impedance = impedance;
	}

	public int getImpedance() {
		return impedance;
	}

	public void setImpedance(int impedance) {
		this.impedance = impedance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weightInGrams;
	}

	public void setWeight(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}

	public String getDriver() {
		return driverType;
	}

	public void setDriver(String driverType) {
		this.driverType = driverType;
	}

	@Override
	public String toString() {
		return "Headphone [id=" + id + ", name=" + name + ", weightInGrams=" + weightInGrams + ", driverType="
				+ driverType + ", impedance=" + impedance + "]";
	}
	
}
