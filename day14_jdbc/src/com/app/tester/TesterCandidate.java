package com.app.tester;

import java.sql.Date;
import java.util.Scanner;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class TesterCandidate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			UserDaoImpl userDao = new UserDaoImpl();
			CandidateDaoImpl candidateDao = new CandidateDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options \n1. Login \n" + "0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						// login
						System.out.println("Enter email n password");
						User user = userDao.signIn(sc.next(), sc.next());
						if (user.getRole().equals("voter")) {
							if (user.isStatus() == false) {
								System.out.println("---------------List Of Candidates---------------");
								candidateDao.getAllCandidate().forEach(System.out::println);
								System.out.println("Select Candidate id");
								candidateDao.addVote(sc.nextInt());
								userDao.updateStatus(user.getUserId());
								System.out.println("Vote Casted Succesfully!!");
							} else
								System.out.println("Vote Already Casted!!");
						} 
						else if (user.getRole().equals("admin")) {
							while(!exit) {
							System.out.println("Options \n1. Add Voter \n" + "2. Display Top 2 candidates\n"
									+ "3. Party Wise votes \n4. Remove Voter\n" + "0.Exit");
							switch (sc.nextInt()) {
							case 1:
								System.out.println(
										"Enter Voter's details - firstName,  lastName, email,  password,  dob");
								user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
								System.out.println("Reg status " + userDao.voterRegistration(user));
								break;
							case 2:
								System.out.println("----------Top Two voted Candidates------------");
								candidateDao.getTopTwoCandidates().forEach(System.out::println);
								break;
							case 3:
								System.out.println("Total votes earned by Party:");
								candidateDao.getPartyWiseVotes()
										.forEach((k, v) -> System.out.printf("Party:  %-15s  Total Votes:  %-5d \n",k, v));
								break;
							case 4:
								System.out.println("Enter Voter's id to delete");
								System.out.println("Status " + userDao.deleteVoter(sc.nextInt()));
								break;

							case 0:
								exit = true;
								userDao.cleanUp();
								candidateDao.cleanup();
								break;
							}
							}

						} else
							System.out.println("Invalid email or password!!!!");
						break;
					case 0:
						exit = true;
						userDao.cleanUp();
						candidateDao.cleanup();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
