package ismek;

public class KumasBilgisi {
	private String kod;// cesidi/renk
	private float birimFiyat;
	private String iplikCesidi; // polyester,pamuk,keten,viskon,elastan
	private String renk;

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public float getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(float birimFiyat) {
		this.birimFiyat = birimFiyat;
	}

	public String getIplikCesidi() {
		return iplikCesidi;
	}

	public void setIplikCesidi(String iplikCesidi) {
		this.iplikCesidi = iplikCesidi;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

}
