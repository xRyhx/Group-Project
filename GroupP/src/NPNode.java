import java.util.ArrayList;

public class NPNode {
	private String pronoun;
	private String properNoun;
	private String determinant;
	private Nominal nominal;
	public NPNode() {}
	public String getPronoun() {
		return pronoun;
	}
	public void setPronoun(String pronoun) {
		this.pronoun = pronoun;
	}
	public String getProperNoun() {
		return properNoun;
	}
	public void setProperNoun(String properNoun) {
		this.properNoun = properNoun;
	}
	public String getDeterminant() {
		return determinant;
	}
	public void setDeterminant(String determinant) {
		this.determinant = determinant;
	}
	public Nominal getNominal() {
		return nominal;
	}
	public void setNominal(Nominal nominal) {
		this.nominal = nominal;
	}
	public int checkType(ArrayList<String> list,int index) {
		
		if(isPreNoun(list.get(index))) {
			return 0;
		}
		else {
			if(isPronoun(list.get(index))) {
				return 1;
			}else {
				if(isProperNoun(list.get(index))) {
					return 2;
				}else {
					if(isDeterminant(list.get(index))&&isNominal((list.get(index+1).compareTo("")==0)?"":list.get(index+1))) 
					{
						return 3;
					}
				}
			}
		}
		return -1;
	}
	public boolean isDeterminant(String string) {
		return false;
	}
	public boolean isNominal(String string) {
		return false;
	}
	protected boolean isPreNoun(String string) {
		char[] ca = string.toCharArray();
		if(
			(ca[0]=='A')||
			(ca[0]=='a')|| 
			(((ca[0]=='T')||ca[0]=='t')&&(ca[1]=='h')&&(ca[2]=='e'))
			) {
			return true;
		}
		else {return false;}
	}
	public boolean isProperNoun(String string) {
		char[] ca = string.toCharArray();
		if((ca[0]==65)||
				(ca[0]==66)||
				(ca[0]==67)||
				(ca[0]==68)||
				(ca[0]==69)||
				(ca[0]==70)||
				(ca[0]==71)||
				(ca[0]==72)||
				(ca[0]==73)||
				(ca[0]==74)||
				(ca[0]==75)||
				(ca[0]==76)||
				(ca[0]==77)||
				(ca[0]==78)||
				(ca[0]==79)||
				(ca[0]==80)||
				(ca[0]==81)||
				(ca[0]==82)||
				(ca[0]==83)||
				(ca[0]==84)||
				(ca[0]==85)||
				(ca[0]==86)||
				(ca[0]==87)||
				(ca[0]==88)||
				(ca[0]==89)||
				(ca[0]==90)||
				(string.equals("downtown"))
				){return true;}
			else {return false;}
	}
	
	public boolean isPronoun(String string) {
		char[] ca = string.toCharArray();
		if ((ca[0]=='I')||((ca[0]=='W')&&(ca[1]=='e'))){return true;}else return false;
	}
	
}
