import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class A1083331_checkpoint1_mapDrawer {

     /*********************************The TODO********************************
         * TODO (3) After reading those data from the file,you need to draw the map and draw the location of the obstacle. 
         * Please follow the rules below.
         * Hint1: You must draw the width and height of the map according to the content of the file.If the map size is "3,4",it means 
         *        that you need to draw three columns and four rows.And the top left starting point is (1,1)
         * Hint2: The left side of the map must be indented to eight half-shaped spaces
         * Hint3: One blank line is required on the top and bottom of the map
         * Hint4: The outer frame of the map is composed of "0". There is a half-shaped blank between each 0 on the upper and lower sides
         * Hint5: Inside of the grid of the map ,the center  is marked with "X" (yes) or "." (no) to indicate whether there are obstacles at that 
                  location, plus three half-shaped blanks on the left and right.
         * Hint6: Outside of the grid of the map,the four corners of each grid are composed of "0", the upper and lower sides are 
                  composed of three "-" and four half-shaped blanks, and the left and right sides are composed of three "|". If this side is the outer frame of the map, it is composed of "0"
    **********************************The End of the TODO**********************/

    public void drawMap(int x,int y,ArrayList<Integer[]> obstacleList){

        /********************************************************************************************
            START OF YOUR CODE
        ********************************************************************************************/
        try{   
            int length=4*y;
            int width=8*x;
            // System.out.println(length+" "+width);


            System.out.println();
            for(int i=0;i<=length;i++){
            	System.out.print("        ");
            	for(int k=0;k<=width;k++){
            		if(i==0 || i==length || k==0 || k==width){
	            		if(k%2!=0 && (i==0 ||i==length)){
	            			System.out.print(" ");
	            		}
	            		else{
            				System.out.print("0");
	            		}
            		}
            		else if(i%4==0 && k%8==0){
            			System.out.print("0");
            		}
            		else if(i%4==0 && k%2==0){
            			System.out.print("-");
            		}
            		else if(k%8==0){
            			System.out.print("|");
            		}
            		else if(i%2==0 && k%4==0){
            			int check1=0;
            			for(int a=0;a<obstacleList.size();a++){
            				int x1=obstacleList.get(a)[0];
            				int y1=obstacleList.get(a)[1];
            				if(4+(x1-1)*8==k && 2+(y1-1)*4==i){
            					check1=1;
            					System.out.print("X");
            				}
            			}
            			if(check1==0){
            				System.out.print(".");
            			}
            		}
            		else{
            			System.out.print(" ");
            		}
            	}
            	System.out.println();
            }
            System.out.println();
      	}
      	catch(Exception e){
      		System.out.print("Error in map information.");
      		System.exit(0);
      	}
        /********************************************************************************************
            END OF YOUR CODE
        ********************************************************************************************/    
    
        }
    
}
