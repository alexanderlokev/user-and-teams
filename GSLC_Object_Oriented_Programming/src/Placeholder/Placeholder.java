package Placeholder;

import java.util.ArrayList;

public class Placeholder{
	private ArrayList<Users> users = new ArrayList<>();
	ArrayList<Teams> teams = new ArrayList<>();
	Integer teamID;
	
	public Placeholder(){
	}
	
	public Placeholder(Integer teamID){
		this.teamID = teamID;
	}
	
	public void addUser(Users user){
		users.add(user);
	}
	
	public void addTeam(Teams team){
		teams.add(team);
	}
	
	public ArrayList<Teams> getTeams(){
		return teams;
	}
	
	public ArrayList<Users> getUsers(){
		return users;
	}	
}
