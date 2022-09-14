import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;


public class A1083331_checkpoint1_fileReader {

    //Description :To store the height of the map
    public  int Height = 0;
    //Description :To store the height of the map
    public  int Width = 0;
    //Description :To store the locations of the obstacle
    public  ArrayList<Integer[]> obstacleList = new ArrayList<Integer[]>() ;


     /*********************************The TODO********************************
         * TODO (2) In this part, you need to read the size of  map and the locations of the obstacle from the file. 
         * Hint1: You could read the HTML file directly, not need to import other library.
         * Hint2: You need to use ArrayList<Integer[]> to store those information.
         * Hint3: We provide the following methods you may use substring(), startsWith(), replaceAll(), strip() 
    **********************************The End of the TODO**********************/
    
    public void readFile(String fileName) throws IOException{

    /********************************************************************************************
	    START OF YOUR CODE
	********************************************************************************************/
        try{    
            FileReader fileReader = new FileReader(fileName);
        	BufferedReader bufferedReader = new BufferedReader(fileReader); 
        	String readline="";
        	ArrayList<String> html=new ArrayList<String>();
        	ArrayList<String> size1=new ArrayList<String>();
       		ArrayList<String> size2=new ArrayList<String>();
       		ArrayList<String> size_final=new ArrayList<String>();
        	
        	ArrayList<String> ob1=new ArrayList<String>();
       		ArrayList<String> ob2=new ArrayList<String>();
       		ArrayList<String> ob_final=new ArrayList<String>();

        	int size_check=0;
        	int ob_check=0;
        	while(readline!=null) {
        		readline=bufferedReader.readLine();
        		if(readline==null){
        			break;
        		}
        		String temp="";
        		temp=readline;
        		temp=temp.trim();
        		if(temp=="" || temp=="\n" || temp=="\t"){
        			continue;
        		}
        		html.add(temp);
        	}
        	for(int i=0;i<html.size();i++){
        		String row=html.get(i);
        		if(row.startsWith("<table  class=\"size\" >")){
        			size_check=1;
        		}
        		if(row.startsWith("</table>")){
        			size_check=0;
        		}        		
        		if(size_check==1){
        			size1.add(row);
        		}

        		if(row.startsWith("<table  class=\"location\" >")){
        			ob_check=1;
        		}
        		if(row.startsWith("</table>")){
        			ob_check=0;
        		}        		
        		if(ob_check==1){
        			ob1.add(row);
        		}
        	}
        	int size_check2=0;
        	for(int g=0;g<size1.size();g++){
        		String temp=size1.get(g);
        		if(temp.startsWith("<td>")){
        			size_check2++;
        		}
        		if(size_check2==6 || size_check2==5){
        			size2.add(temp.replaceAll("<td>","").replaceAll("</td>","").trim());
        			if(size_check2==6){
        				break;
        			}
        		}
        	}

        	int ob_check2=0;
        	for(int g=0;g<ob1.size();g++){
        		String temp=ob1.get(g);
        		if(temp.startsWith("<td>") && temp.length()>0){
        			ob2.add(temp.replaceAll("<td>","").replaceAll("</td>","").trim());
        		}
        	}
        	ob2.remove(0);
        	ob2.remove(0);
        	for(int k=0;k<ob2.size();k++){
        		if(k%2!=0){
					String[] temp1=new String[2];
					Integer[] ob_location=new Integer[2];
					temp1=ob2.get(k).replace("(","").replace(")","").split(",");		
					ob_location[0]=Integer.valueOf(temp1[0]);
					ob_location[1]=Integer.valueOf(temp1[1]);
					obstacleList.add(ob_location);
        		}
        	}


        	for(int k=0;k<size2.size();k++){
        		if(size2.get(k).length()==0){
        			continue;
        		}
        		size_final.add(size2.get(k));
        	}
            boolean check1=size_final.get(0).matches("-?\\d+");
            boolean check2=size_final.get(1).matches("-?\\d+");
            if(check1==false || check2==false){
                throw new NumberFormatException();
            }           
        	setWidth(Integer.valueOf(size_final.get(0)));
        	setHeight(Integer.valueOf(size_final.get(1)));
        }
        catch (NumberFormatException e1) {
            System.out.println("The length,width and the coordinates of obstacle must be Integer.");
            System.exit(0);
        }
        catch(Exception e){
            System.out.print("Error in map information.");
            System.exit(0);
        }

    /********************************************************************************************
	    END OF YOUR CODE
	********************************************************************************************/    

    }

    public void setWidth(int Width){
        this.Width = Width;
    }

    public void setHeight(int Height){
        this.Height = Height;
    }

    public void setobstacleList(ArrayList<Integer[]> obstacleList){
        this.obstacleList=obstacleList;
    }
    public int getWidth(){
        return Width;
    }
    public int getHeight(){
        return Height;
    }
    public ArrayList<Integer[]> getobstacleList(){
        return obstacleList;
    }
}
