package CSMA;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		
	//	method1();
                method2();
	}
        public static void method2(){
            int nbClients=0;
		int nbPackets=0;
		int delay = 0;
		String patern=null;
                BufferedReader br=null;
                try{
                    FileInputStream fstream = new FileInputStream("packetSize_H1.txt");
              br = new BufferedReader(new InputStreamReader(fstream));
               
                }
                catch(Exception ex){
                    
                }
              String strLine;
                 List<String> list = new ArrayList<String>(); 
try{
//Read File Line By Line
while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  System.out.println (strLine);
   String [] res = strLine.split(",");
    nbClients=Integer.parseInt(res[0]);
    nbPackets=Integer.parseInt(res[1]);
     delay=Integer.parseInt(res[2]);
     
     Execute(nbClients,nbPackets,delay, "CSMA/CD");
     Execute(nbClients,nbPackets,delay, "CSMA/CA");
}

//Close the input stream
br.close();}
catch(Exception ex){
    
}
        }
        
        static void Execute (int nbClients,int nbPackets,int delay,String patern){

        
		if (patern.equals("CSMA/CD")){
			CSMA_CD[] virtualHosts = new CSMA_CD[nbClients];
			for (int i = 0; i < nbClients; i++){
				virtualHosts[i]= new CSMA_CD("[HOST:" + i + "]", nbPackets, delay);
			}
			//Starting host threads (start sending)
			for (int j = 0; j < nbClients; j++){
				virtualHosts[j].start();
			}
		} else if (patern.equals("CSMA/CA")){
			CSMA_CA[] virtualHosts = new CSMA_CA[nbClients];
			for (int i = 0; i < nbClients; i++){
				virtualHosts[i] = new CSMA_CA("[HOST:" + i + "]", nbPackets);
			}
			
			for (int j = 0; j < nbClients; j++){
				virtualHosts[j].start();
			}
		}}
        public static void method1(){
            int nbClients;
		int nbPackets;
		int delay = 0;
		String patern;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of hosts");
		nbClients = scan.nextInt();
		System.out.print("Enter the number of packets you need to sent per hosts");
		nbPackets = scan.nextInt();
		System.out.print("Enter the pattern (CSMA/CD or CSMA/CA)");
		patern = scan.next();
		
		if (patern.equals("CSMA/CD")){
			System.out.print("Enter the delay time");
			delay = scan.nextInt();
		}
		scan.close();
		if (patern.equals("CSMA/CD")){
			CSMA_CD[] virtualHosts = new CSMA_CD[nbClients];
			for (int i = 0; i < nbClients; i++){
				virtualHosts[i]= new CSMA_CD("[HOST:" + i + "]", nbPackets, delay);
			}
			//Starting host threads (start sending)
			for (int j = 0; j < nbClients; j++){
				virtualHosts[j].start();
			}
		} else if (patern.equals("CSMA/CA")){
			CSMA_CA[] virtualHosts = new CSMA_CA[nbClients];
			for (int i = 0; i < nbClients; i++){
				virtualHosts[i] = new CSMA_CA("[HOST:" + i + "]", nbPackets);
			}
			
			for (int j = 0; j < nbClients; j++){
				virtualHosts[j].start();
			}
		}
        }
}
