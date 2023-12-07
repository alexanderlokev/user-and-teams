package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Placeholder.Teams;
import Placeholder.Users;
import Repository.RepositoryUser;
import Repository.RepositoryTeams;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connections connect = Connections.getInstance();
        connect.readFile();
        RepositoryUser uRep = new Users();
        RepositoryTeams tRep = new Teams();

        int choice = 0;
        do {
            System.out.printf("\nWelcome to Hackathon Team Management\n1. Menu\n2. Insert Data\n3. Show\n4. Exit\n>> ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 : {
                    // Hi
                }
                case 2 : {
                    int UserorTeam;
                    do {
                        System.out.println("Which table to insert?\n1. User\n2.Teams\n>> ");
                        UserorTeam = scan.nextInt();
                        scan.nextLine();
                        if (UserorTeam == 1) {
                            System.out.println("Add Name: ");
                            scan.nextLine();
                            System.out.println("Add NIM: ");
                            scan.nextLine();
                            System.out.println("Add Team name: ");

                            RepositoryTeams.checkExistingTeam(String team_name);
                        } else if (UserorTeam == 2) {
                            System.out.print("Add Team name: ");
                            String team_name = scan.nextLine();
                            tRep.insert(team_name, connect);
                        }
                    } while (UserorTeam != 1 && UserorTeam != 2);
                }
                case 3 : {
                    int choice3;
                    int condition;
                    do {
                        System.out.println("Which table to show? 1. User 2. Team.");
                        choice3 = scan.nextInt();
                        scan.nextLine();

                        do {
                            System.out.println("Want to filter by condition? 1. Yes, 2. No.");
                            condition = scan.nextInt();
                            scan.nextLine();
                        } while (condition != 1 && condition != 2);

                        if (choice3 == 1) {
                            if (condition == 1) {
                                System.out.println("Add condition, separate by semicolon [filterType (e.g name, teamid);= or !=;filter");
                                String[] temp = scan.nextLine().split(";");

                                System.out.println("Use join? (y/n)");
                                String Join;
                                do {
                                    Join = scan.nextLine();
                                } while (!Join.equalsIgnoreCase("y") && !Join.equalsIgnoreCase("n"));

                                Boolean join = Join.equalsIgnoreCase("y");
                                try {
                                    String filterType = temp[0];
                                    String[] filter = {temp[1], temp[2]};
                                    String table = null;

                                    if (join) {
                                        table = "Team";
                                        ArrayList<Users> filteredUser = uRep.find(filterType, filter, join, table, connect);
                                        Teams joinTeam;
                                        System.out.println("NIM | Name | Team Name");
                                        for (Users user : filteredUser) {
                                            joinTeam = tRep.joinTeamID(user.getTeamID(), connect);
                                            System.out.println(user.getNIM() + " | " + user.getName() + " | " + joinTeam.getTeamName());
                                        }
                                    }

                                    if (!join) {
                                        ArrayList<Users> filteredUser = uRep.find(filterType, filter, false, null, connect);
                                        System.out.println("NIM | Name | TeamID");
                                        for (Users user : filteredUser) {
                                            System.out.println(user.getNIM() + " | " + user.getName() + " | " + user.getTeamID());
                                        }
                                    }

                                } catch (ArrayIndexOutOfBoundsException e) {
                                    e.getStackTrace();
                                    System.out.println("Please input the correct format!");
                                    scan.nextLine();
                                }
                            } else if (condition == 2) {
                                ArrayList<Users> showUser = uRep.getUsers(connect);
                                System.out.println("NIM | Name | Team_ID");
                                for (Users user : showUser) {
                                    System.out.println(user.getNIM() + " | " + user.getName() + " | " + user.getTeamID());
                                }
                            }
                        } else if (choice3 == 2) {
                            if (condition == 1) {
                                System.out.println("Add condition, separate by semicolon [filterType;= or !=;filter");
                                String[] temp = scan.nextLine().split(";");
                                try {
                                    String filterType = temp[0];
                                    String[] filter = {temp[1], temp[2]};

                                    ArrayList<Teams> showTeam = tRep.find(filterType, filter, connect);
                                    System.out.println("Team_Name | Team_ID");
                                    for (Teams team : showTeam) {
                                        System.out.println(team.getTeamName() + " | " + team.getTeamID());
                                    }

                                } catch (ArrayIndexOutOfBoundsException e) {
                                    e.getStackTrace();
                                    System.out.println("Please input the proper format!");
                                    scan.nextLine();
                                }
                            } else if (condition == 2) {
                                ArrayList<Teams> showTeam = tRep.getTeams(connect);
                                System.out.println("Team_Name | Team_ID");
                                for (Teams team : showTeam) {
                                    System.out.println(team.getTeamName() + " | " + team.getTeamID());
                                }
                            }
                        }
                    } while (choice3 != 1 && choice3 != 2);
                }
                case 4 : System.exit(0);
                break;
                default : System.out.println("Invalid choice. Please choose again.");
                break;
            }
        } while (choice != 4);
    }
}
