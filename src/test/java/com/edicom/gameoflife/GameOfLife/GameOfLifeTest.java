package com.edicom.gameoflife.GameOfLife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)
public class GameOfLifeTest {
	

	private static final boolean STATE_DEAD = false;
	private static final boolean STATE_ALIVE = true;

	@DataProvider
	public static Object[][] DataTwoOrThreeCellAlive(){
		return new Object[][] {
			{2, STATE_ALIVE},
			{3, STATE_ALIVE}
		};
	}
	
	@DataProvider
	public static Object[][] DataMoreThreeCellAlive(){
		return new Object[][] {
			{4, STATE_DEAD},
			{5, STATE_DEAD},
			{6, STATE_DEAD},
			{7, STATE_DEAD},
			{8, STATE_DEAD}
		};
	}
	
	
	
	@Test
	public void isAlive() {
		Cell cell= new Cell(STATE_ALIVE);
		boolean result = cell.getState();
		
		assertTrue(result);
	}
	
	@Test
	public void isDead() {
		Cell cell= new Cell(STATE_DEAD);
		boolean result = cell.getState();
		
		assertFalse(result);
	}
	
	@Test
	public void testOneNeighborLife() {
		Cell cell= new Cell(STATE_ALIVE);
		int neighbors = 1;
		
		Cell.nextStage(cell,neighbors);
		
		assertFalse(cell.getState());
		
	}
	
	@Test
	@UseDataProvider("DataTwoOrThreeCellAlive")
	public void testTwoOrThreeNeighborLife(final int input, final boolean expected) {
		Cell cell= new Cell(STATE_ALIVE);
		
		Cell.nextStage(cell,input);
		
		assertEquals(expected, cell.getState());
		
	}
	
	@Test
	@UseDataProvider("DataMoreThreeCellAlive")
	public void testMoreThreeNeighborLife(final int input, final boolean expected) {
		Cell cell= new Cell(STATE_ALIVE);
		
		Cell.nextStage(cell,input);
		
		assertEquals(expected, cell.getState());
		
	}
	
	@Test
	public void testThreeNeighborLife() {
		Cell cell= new Cell(STATE_DEAD);
		int neighbors = 3;
		
		Cell.nextStage(cell,neighbors);
		
		assertTrue(cell.getState());
		
	}
}
