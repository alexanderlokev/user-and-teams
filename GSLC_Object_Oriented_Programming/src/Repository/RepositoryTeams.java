package Repository;
import java.util.ArrayList;
import Main.Connections;
import Placeholder.Teams;

public interface RepositoryTeams{
	void insert(String teamName, Connections connect);
	
	ArrayList<Teams> find(String filterType, String[] filter, Connections connect);
	
	Teams findOne(String filterType, String[] filter, Connections connect);
	
	ArrayList<Teams> getTeams(Connections connect);
	
	Teams joinTeamID(Integer teamID, Connections connect);

	static void checkExistingTeam(Object string) {
		// TODO Auto-generated method stub
		
	}
}
