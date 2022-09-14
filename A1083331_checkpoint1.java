import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class A1083331_checkpoint1 {

    
    //Description :To store the filename
    public static String fileName = "" ;
    
     /*********************************The TODO********************************
         * TODO (1)Fill in and use the following functions to achieve the requirements from the documentation.
         * Hint1: You need to get the filename from the Command Line Arguments.
         * Hint2: Also, you need to pass in the correct parameters to finish those methods.
    **********************************The End of the TODO**********************/
    public static void main(String args[]){

        /********************************************************************************************
            START OF YOUR CODE
        ********************************************************************************************/

       

        A1083331_checkpoint1_fileReader fileReader = new A1083331_checkpoint1_fileReader();
        A1083331_checkpoint1_mapDrawer mapDrawer = new A1083331_checkpoint1_mapDrawer();


        try{
        	fileName=args[0];
            fileReader.readFile(fileName);


                
            mapDrawer.drawMap(fileReader.getWidth(),fileReader.getHeight(),fileReader.obstacleList);
               
                

        }catch (IOException e1) {
            System.out.println("File does not exists");
        }
		catch (NumberFormatException e1) {
		            System.out.println("The length ,width and the coordinates of obstacle must be Integer.");
		        }
       
      
        /********************************************************************************************
            END OF YOUR CODE
        ********************************************************************************************/   
    }

    



}
