public class refineData {
	public static void main(String args[]) {
		System.out.println(refineText("This@is a__n  Example"));//	output	:		ThisisanExample
	}
	
	public static String refineText(String data) {//Function to refine string to get valid characters
		if(data==null) {
			return "NoValue";//In case if user enters no value
		}
		int length=data.length();
		String refinedValue="";
		String invalid="@ _";
		for(int i=0;i<length;i++) {
			if(data.charAt(i)==invalid.charAt(0)||data.charAt(i)==invalid.charAt(1)||data.charAt(i)==invalid.charAt(2)) {
				continue;
			}
			refinedValue+=data.charAt(i);
		}
		if(refinedValue=="") {
			return "Empty";//in case user enters all invalid characters
		}
		return refinedValue;
	}
}
