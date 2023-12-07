package Main;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Placeholder.*;
public class Connections{
	private static Connections connect = null;
	private Connections(){
		buffer = new Placeholder();
	}
	public static Connections getInstance(){
    	if(connect == null) 
    		connect = new Connections();    	
    	return connect;
    }
	Placeholder buffer;
    Scanner scan;
    int[] jumlahmember = new int[101];
    
    public void readFile(){
        try{
        	buffer = new Placeholder();

            File usercsv = new File("Database/user.csv");
            scan = new Scanner(usercsv);
            
            scan.nextLine();
            
            while (scan.hasNextLine()){
                String[] temp = scan.nextLine().split(",");
                Integer teamID = Integer.parseInt(temp[2]);
                
                Users user = new Users(temp[0], temp[1], teamID);
                buffer.addUser(user);
                jumlahmember[teamID]++;
            }
            scan.close();
            
            File teamcsv = new File("Database/teams.csv");//
            scan = new Scanner(teamcsv);
            
            scan.nextLine();
            
            while(scan.hasNextLine()){
            	String[] temp = scan.nextLine().split(",");
            	Teams team = new Teams(Integer.parseInt(temp[0]),temp[1]);
            	buffer.addTeam(team);
            }
            scan.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
	public void writeTeam(String teamName) {
		// TODO Auto-generated method stub
		
	}
	public void writeUser(String nIM, String name, String teamName) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Users> findUser(String filterType, String[] filter, Boolean join, String table) {
		// TODO Auto-generated method stub
		return null;
	}
	public Users findOneUser(String filterType, String[] filter, Boolean join, String table) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Users> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	public Teams findOneTeam(String filterType, String[] filter) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Teams> findTeam(String filterType, String[] filter) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Teams> getTeams() {
		// TODO Auto-generated method stub
		return null;
	}
	public Teams joinTeamID(Integer teamID) {
		// TODO Auto-generated method stub
		return null;
	}
}
