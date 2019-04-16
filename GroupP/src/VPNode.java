import java.util.ArrayList;

public class VPNode {
	private String verbForm;
	private String verb;
	private NPNode nounPlause;
	private PPNode prepositionPlause;
//Methods
	public VPNode() {
	}
	
	public String getVerbForm() {
		return verbForm;
	}
	public void setVerbForm(String verbForm) {
		this.verbForm = verbForm;
	}
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public NPNode getNounPlause() {
		return nounPlause;
	}
	public void setNounPlause(NPNode nounPlause) {
		this.nounPlause = nounPlause;
	}
	public PPNode getPrepositionPlause() {
		return prepositionPlause;
	}
	public void setPrepositionPlause(PPNode prepositionPlause) {
		this.prepositionPlause = prepositionPlause;
	}
	public int checkType(ArrayList<String> list, int index) {
		if(isPreVerb(list.get(index))) {
			return 0;
		}if(isVerb(list.get(index))){return 1;}
		return -1;
	}
	public boolean isPreVerb(String string) {
		
		if(string.equals("has")||
				string.equals("would")||
				string.equals("could")||
				string.equals("can")||
				string.equals("will")||
				string.equals("may")||
				string.equals("might")||
				string.equals("have")
				||string.equals("should")
				||string.equals("to")
				
				) {return true;}
		else {return false;}
	}
	public boolean isVerb(String string) {
		if(string.equals("want")||
				string.equals("go")||
				string.equals("get")||
				string.equals("hire")||
				string.equals("wish")||
				string.equals("travel")||
				string.equals("move")
				) {return true;}else {return false;}
	}
	
	
}
