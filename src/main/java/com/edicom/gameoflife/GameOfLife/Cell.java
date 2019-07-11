package com.edicom.gameoflife.GameOfLife;

public class Cell {
	private boolean state;
	
	public Cell() {}

	public Cell(boolean state) {
		super();
		this.state = state;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public static void nextStage(Cell cell, int neighbors ) {
		if(neighbors<=1) {
			cell.setState(false);
		}else if(neighbors>3) {
			cell.setState(false);
		}else if(neighbors==3) {
			cell.setState(true);
		}
	}
	
}
