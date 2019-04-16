
public abstract class Nominal {
	private String Noun;
	private Nominal nominal;
	Nominal(){
		Noun="";
		nominal.setNominal(null);
	}
	public String getNoun() {
		return Noun;
	}
	public void setNoun(String noun) {
		Noun = noun;
	}
	public Nominal getNominal() {
		return nominal;
	}
	public void setNominal(Nominal nominal) {
		this.nominal = nominal;
	}
}
