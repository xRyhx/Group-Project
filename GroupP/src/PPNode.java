
public class PPNode {
	private String preposition;
	private NPNode nounPlause;
	//Methods
	public PPNode(){
		preposition="";
		nounPlause.setPronoun("");
		nounPlause.setNominal(null);
		nounPlause.setProperNoun("");
		nounPlause.setDeterminant("");
	}
	public String getPreposition() {
		return preposition;
	}
	public void setPreposition(String preposition) {
		this.preposition = preposition;
	}
	public NPNode getNounPlause() {
		return nounPlause;
	}
	public void setNounPlause(NPNode nounPlause) {
		this.nounPlause = nounPlause;
	}
	public String getPronoun() {
		return nounPlause.getPronoun();
	}
	public void setPronoun(String pronoun) {
		nounPlause.setPronoun(pronoun);
	}
	public String getProperNoun() {
		return nounPlause.getProperNoun();
	}
	public void setProperNoun(String properNoun) {
		nounPlause.setProperNoun(properNoun);
	}
	public String getDeterminant() {
		return nounPlause.getDeterminant();
	}
	public void setDeterminant(String determinant) {
		nounPlause.setDeterminant(determinant);
	}
	public Nominal getNominal() {
		return nounPlause.getNominal();
	}
	public void setNominal(Nominal nominal) {
		nounPlause.setNominal(nominal);
	}
}
