package com.dscandshailesh;

public class Classroom {

	private int roomid;
	private String rname;
	private Teacher teacher;
	
	
	
	public Classroom(int roomid , String rname, Teacher teacher) {
		this.roomid=roomid;
		this.rname=rname;
		this.teacher=teacher;
	}



	@Override
	public String toString() {
		return "Classroom [Roomid=" + roomid + ", RoomName=" + rname + ", " +teacher.toString() + "]";
	}



	public int getRoomid() {
		return roomid;
	}



	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}



	public String getRname() {
		return rname;
	}



	public void setRname(String rname) {
		this.rname = rname;
	}
	
	
	
	
}
