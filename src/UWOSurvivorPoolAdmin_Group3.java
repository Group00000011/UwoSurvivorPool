
import java.awt.*;
import java.io.*;


public class UWOSurvivorPoolAdmin_Group3 {
//	private Player[] players;
//	private Contestant[] contestants;
//	
//	public void readPlayers(String fileName){
//        try{
//            DataInputStream input = new DataInputStream(new FileInputStream(fileName));
//            BufferedReader in = new BufferedReader(new InputStreamReader(input));
//            String currPlayer = in.readLine(), firstName="", lastName="", userID="";
//            Player currPlayerObj;
//            Boolean first, last, ID;
//            first=last=ID=false;
//            while(currPlayer!=null){
//            for(int i=0; i<currPlayer.length(); i++){
//                char ch=currPlayer.charAt(i);
//                while(!first){
//                	if(ch=='+')
//                		first=true;
//                	else
//                		firstName=firstName+ch;
//               }//end of first name field
//                while(!last && first){
//                	if(ch=='+')
//                		last=true;
//                	else
//                		lastName=lastName+ch;
//               }//end of  last name field
//                while(!ID && last){
//                	if(ch=='+')
//                		ID=true;
//                	else
//                		userID=userID+ch;
//               }//end of first last name field
//               currPlayerObj=new Player(firstName, lastName, userID);
//               addPlayer(currPlayerObj);
//            }//end of scanning through currplayer
//            first=last=ID=false;
//            firstName=lastName=userID="";
//            currPlayer=in.readLine();
//            }//end of currplayer
//        }
//        catch(IOException e){}//unharmful
//	}
//	
//	
//    
//	public void addPlayer(Player p){
//		
//		if(this.players==null){
//			this.players=new Player[1];
//			this.players[0]= p;
//		}
//		else{
//			Player[] newPlayers=new Player[this.players.length];
//			for(int i=0;i<this.players.length; i++){
//				newPlayers[i]=this.players[i];
//			}
//			newPlayers[this.players.length] = p ;
//			this.players=newPlayers;
//		}
//	}
//	
//	public void writePlayers(String fileName){
//        BufferedWriter bWr = null;
//        
//        try {
//            
//            bWr = new BufferedWriter(new FileWriter(fileName));
//            for(int i=0;i<this.players.length;i++){
//            	
//            }
//            //Start writing to the output stream
//            bufferedWriter.write("Writing line one to file");
//            bufferedWriter.newLine();
//            bufferedWriter.write("Writing line two to file");
//	}
//        
//	}

	public static void main(String[] args) 	{

		SurvivorPoolAdminGUI gui = new SurvivorPoolAdminGUI();
	}
}


