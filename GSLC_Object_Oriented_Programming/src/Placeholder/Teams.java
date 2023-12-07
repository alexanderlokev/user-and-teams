package Placeholder;

import Repository.RepositoryTeams;

import java.util.ArrayList;

import Main.Connections;

public class Teams extends Placeholder implements RepositoryTeams{
	private String teamName;
	
	public Teams(Integer teamID, String teamName){
		super(teamID);
		this.teamName = teamName;
	}
	
	public Teams(){
		
	}
	
	public void insert(String teamName, Connections connect){
		connect.writeTeam(teamName);
	}
	
	public ArrayList<Teams> getTeams(Connections connect){
		return connect.getTeams();
	}
	
	public ArrayList<Teams> find(String filterType, String[] filter, Connections connect){
		return connect.findTeam(filterType, filter);
	}
	
	public Teams findOne(String filterType, String[] filter, Connections connect){
		return connect.findOneTeam(filterType, filter);
	}
	
	public Teams joinTeamID(Integer teamID, Connections connect){
		return connect.joinTeamID(teamID);
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public Integer getTeamID(){
		return teamID;
	}
}
