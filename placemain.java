package rplace.main.rplace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import rplace.main.rplace.Color.Color;


public class placemain {

	public static void main(String[] args) throws FileNotFoundException {

		try (Scanner sc = new Scanner(new File("src\\2022_place_canvas_history.csv"), "UTF-8")){
			
			
			sc.nextLine();
			int i=1,j=0,k=0;
			
            int[][] Cord = new int[2000][2000];
            int Top_Most_place = 100;
            int[][] Most_Place = new int[3][Top_Most_place+1];
            String st="";
            int Color[]= new int[32];
            String Color_Name[] = new String[32];
            
	        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            String[] str = line.split(",");

	            int Coordinate_X =	Integer.parseInt(str[3].substring(1));
	            int Coordinate_Y = 	Integer.parseInt(str[4].substring(0,str[4].length()-1));
	            
	            Cord[Coordinate_X][Coordinate_Y]++;

	        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	            
	            switch(str[2]) {
	            	case "#FFFFFF" :
	            		Color[0]++;
	            		Color_Name[0]="#FFFFFF";
	            		break;
	            	case "#FFF8B8" :
	            		Color[1]++;
	            		Color_Name[1]="#FFF8B8";
	            		break;
	            	case "#FFD635" :
	            		Color[2]++;
	            		Color_Name[2]="#FFD635";
	            		break;
	            	case "#FFB470" :
	            		Color[3]++;
	            		Color_Name[3]="#FFB470";
	            		break;
	            	case "#FFA800" :
	            		Color[4]++;
	            		Color_Name[4]="#FFA800";
	            		break;
	            	case "#FF99AA" :
	            		Color[5]++;
	            		Color_Name[5]="#FF99AA";
	            		break;
	            	case "#FF4500" :
	            		Color[6]++;
	            		Color_Name[6]="#FF4500";
	            		break;
	            	case "#FF3881" :
	            		Color[7]++;
	            		Color_Name[7]="#FF3881";
	            		break;
	            	case "#E4ABFF" :
	            		Color[8]++;
	            		Color_Name[8]="#E4ABFF";
	            		break;
	            	case "#DE107F" :
	            		Color[9]++;
	            		Color_Name[9]="#DE107F";
	            		break;
	            	case "#D4D7D9" :
	            		Color[10]++;
	            		Color_Name[10]="#D4D7D9";
	            		break;
	            	case "#BE0039" :
	            		Color[11]++;
	            		Color_Name[11]="#BE0039";
	            		break;	
	            	case "#9C6926" :
	            		Color[12]++;
	            		Color_Name[12]="#9C6926";
	            		break;
	            	case "#94B3FF" :
	            		Color[13]++;
	            		Color_Name[13]="#94B3FF";
	            		break;
	            	case "#898D90" :
	            		Color[14]++;
	            		Color_Name[14]="#898D90";
	            		break;
	            	case "#811E9F" :
	            		Color[15]++;
	            		Color_Name[15]="#811E9F";
	            		break;
	            	case "#7EED56" :
	            		Color[16]++;
	            		Color_Name[16]="#7EED56";
	            		break;
	            	case "#6D482F" :
	            		Color[17]++;
	            		Color_Name[17]="#6D482F";
	            		break;
	            	case "#6D001A" :
	            		Color[18]++;
	            		Color_Name[18]="#6D001A";
	            		break;
	            	case "#6A5CFF" :
	            		Color[19]++;
	            		Color_Name[19]="#6A5CFF";
	            		break;
	            	case "#51E9F4" :
	            		Color[20]++;
	            		Color_Name[20]="#51E9F4";
	            		break;
	            	case "#515252" :
	            		Color[21]++;
	            		Color_Name[21]="#515252";
	            		break;
	            	case "#493AC1" :
	            		Color[22]++;
	            		Color_Name[22]="#493AC1";
	            		break;
	            	case "#3690EA" :
	            		Color[23]++;
	            		Color_Name[23]="#3690EA";
	            		break;         		
	            	case "#2450A4" :
	            		Color[24]++;
	            		Color_Name[24]="#2450A4";
	            		break;
	            	case "#00CCC0" :
	            		Color[25]++;
	            		Color_Name[25]="#00CCC0";
	            		break;
	            	case "#00CC78" :
	            		Color[26]++;
	            		Color_Name[26]="#00CC78";
	            		break;
	            	case "#00A368" :
	            		Color[27]++;
	            		Color_Name[27]="#00A368";
	            		break;
	            	case "#009EAA" :
	            		Color[28]++;
	            		Color_Name[28]="#009EAA";
	            		break;
	            	case "#00756F" :
	            		Color[29]++;
	            		Color_Name[29]="#00756F";
	            		break;
	            	case "#000000" :
	            		Color[30]++;
	            		Color_Name[30]="#000000";
	            		break;
	            }

		    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
	            } 
			
			for(i=0;i<2000;i++) {
				for(j=0;j<2000;j++) {
					
					if(Cord[i][j]>Most_Place[0][Top_Most_place]) {			//este if solo lo hace un poco mas eficiente
						
						Most_Place[0][Top_Most_place]	= Cord[i][j];
						Most_Place[1][Top_Most_place] = i;
						Most_Place[2][Top_Most_place] = j;
						
						for(k=Top_Most_place-1;Cord[i][j]>Most_Place[0][k] && k>0 ;k--) {
						
							Most_Place[0][k+1]= Most_Place[0][k];
							Most_Place[1][k+1]= Most_Place[1][k];
							Most_Place[2][k+1]= Most_Place[2][k];
							Most_Place[0][k] = Cord[i][j];
							Most_Place[1][k] = i;
							Most_Place[2][k] = j;
					}
				}
			}
			}
			
	        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("\nTop Cords Places \n");
			for(i=1; i <Top_Most_place ; i++) {
				System.out.println(i +"-		Coordinate X: "+Most_Place[1][i]+"		Coordinate Y: "+Most_Place[2][i]+ "		Times: "+Most_Place[0][i]+"\n");
			}
			
	        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			for(j=31;j>0;j--){
			for(i=31;i>0;i--){
				if(Color[i]>Color[i-1]) {
					k=Color[i-1];
					st=Color_Name[i-1];
					
					Color[i-1]=Color[i];
					Color_Name[i-1]=Color_Name[i];
					
					Color[i]=k;
					Color_Name[i]=st;	
				}
			}
			}
			
			System.out.println("\n \n Top Color Places \n");
			for(i=0; i<31 ; i++) {
				System.out.println(i+1 +"-	Color: "+Color_Name[i]+ "		Times: "+Color[i]+"\n");
			}
			
			
	        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			}
				//160353104 lineas
	        }
			
				}
				

		
	


