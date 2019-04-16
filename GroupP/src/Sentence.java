import java.util.ArrayList;

public class Sentence {
	public ArrayList<String> determineStatement(ArrayList<String> list){
		NPNode nounPlause= new NPNode();
		VPNode verbPlause= new VPNode();
		ArrayList<String> LocationList=new ArrayList<String>();
		int index=0;
		int expectedvalue=1;
		int depth=0;
		int j=0;
		while(index!=list.size()) {
			if(expectedvalue==1) {//if Expecting a noun plause then find one.
				j = nounPlause.checkType(list,index);
				if( j == 0 )
				{
					list.remove(index);
				}
				else 
					if(j==1) {
						expectedvalue++;
						}	
					else 
						if(j==2) {
							while(nounPlause.isProperNoun(list.get(index))) {index++;}
							//nounPlause
						}
						if(j==3) {
							//Failure to obey the sentence structure
							return null;	
						}
				
			}
			if(expectedvalue==2) {//if expecting a verb plause then ensure it obeys the rules (at least somewhat)
				if(depth==0) {j = verbPlause.checkType(list,index);}
				if(j==1) {
					depth=1;
				}
				if(depth==1) {
					if(verbPlause.checkType(list,index+2)==1) {
						index=index+2;
						depth=2;
					}else {if(verbPlause.checkType(list, index+1)==1) {index++;}
					depth=2;//depth 2 checks for NP
					}
				}
				if(depth==2) {
					j=nounPlause.checkType(list, index);
					if(j==2) {
						if(list.get(index-1).equals("to")||list.get(index-1).equals("then")) {
							if(nounPlause.isProperNoun(list.get(index))){LocationList.add(list.get(index));}
						}
						if(list.get(index-1).equals("from")) {
							LocationList.add("-");
							LocationList.add(list.get(index));
							LocationList.add("-");
						}
					}
				}
			}
			
			//LocationList = 
		
			index++;
		}
		return LocationList;
	}
}
