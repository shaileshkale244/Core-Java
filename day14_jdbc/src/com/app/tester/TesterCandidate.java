package com.app.tester;

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
				System.out.println("Options 1. Add Votes \n" + "2 : Display Top 2 candidates\n"
						+ "3. Party Wise votes \n" + "0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // login
						System.out.println("Enter email n password");
						User user = userDao.signIn(sc.next(), sc.next());
						if (user.getRole().equals("voter")&& user.isStatus()==false) {
							System.out.println(user);
							candidateDao.getAllCandidate().forEach(System.out::println);
							System.out.println("Select Candidate id");
							candidateDao.addVote(sc.nextInt());
							userDao.updateStatus(user.getUserId());
							System.out.println("Vote Casted Succesfully!!");
						} else
							System.out.println("Invalid email or password!!!!");
						break;
					case 2:
						candidateDao.getTopTwoCandidates().forEach(System.out::println);
						break;
					case 3:
						candidateDao.getPartyWiseVotes().forEach((k,v)->System.out.println(k+" "+v));
						break;

					case 0:
						exit = true;
						// destroy (shutdown/terminate app)
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
