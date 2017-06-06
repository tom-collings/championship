package com.sports.cities.championship.entity;

public class TeamSeason {
	
	private String teamKey;
	private String sportKey;
	private int wins;
	private int losses;
	private int ties;
	private boolean madePlayoffs;
	private boolean madeChampionship;
	private boolean wonChampionship;
	
	
	public String getTeamKey() {
		return teamKey;
	}
	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}
	public String getSportKey() {
		return sportKey;
	}
	public void setSportKey(String sportKey) {
		this.sportKey = sportKey;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getTies() {
		return ties;
	}
	public void setTies(int ties) {
		this.ties = ties;
	}
	public boolean madePlayoffs() {
		return madePlayoffs;
	}
	public void setMadePlayoffs(boolean madePlayoffs) {
		this.madePlayoffs = madePlayoffs;
	}
	public boolean madeChampionship() {
		return madeChampionship;
	}
	public void setMadeChampionship(boolean madeChampionship) {
		this.madeChampionship = madeChampionship;
	}
	public boolean wonChampionship() {
		return wonChampionship;
	}
	public void setWonChampionship(boolean wonChampionship) {
		this.wonChampionship = wonChampionship;
	}
	

}
