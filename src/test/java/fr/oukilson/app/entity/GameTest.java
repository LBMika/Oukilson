package fr.oukilson.app.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.oukilson.app.entity.Game;


public class GameTest {
	
	@Test
	public void getName () {
		Game g = new Game(1,"Monopoly");
		Assertions.assertEquals("Monopoly",g.getName());
	}

	@Test
	public void setNameWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setName("Pocker");
			} catch (Exception e) {
			}
		Assertions.assertEquals("Pocker",g.getName());
	}
	
	@Test
	public void setNameThrowIllegalArgumentException( ) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			String s = "";
			for (int i=0;i<50;i++) {
				s += "A";
			}
			g.setName(s);
		});
	}
	
	@Test
	public void setNameLength45( ) {
		Game g = null ;
		String s = "";
		for (int i=0;i<44;i++) {
			s += "A";
		}
		try {
			g = new Game(1,"Monopoly");
			g.setName(s);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(s,g.getName());		
	}
	
	@Test
	public void constructorWithoutError () {
		Game g = null ;
		try {
			g = new Game(1,"Poker");
		} catch (Exception e) {
			Assertions.fail();
		}
		Assertions.assertNotNull(g);
	}
	
	@Test
	public void constructorNameLength45 () {
		Game g = null ;
		try {
			String s = "";
			for (int i=0;i<44;i++) {
				s += "A";
			}
			g = new Game(1,s);
		} catch (Exception e) {
			Assertions.fail();
		}
		Assertions.assertNotNull(g);
	}
	
	@Test
	public void constructorThrowIllegalArgumentException () {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			String s = "";
			for (int i=0;i<50;i++) {
				s += "A";
			}
			Game g = new Game(1,s);
		});
	}
	
	@Test
	public void setgetMinPlayerWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinPlayer(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getMinPlayer());
	}
	
	@Test
	public void setMinPlayerForOnePlayer( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinPlayer(1);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(1,g.getMinPlayer());
	}
	
	@Test
	public void setMinPlayerThrowIllegalArgumentException( ) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setMinPlayer(-10);
		});
	}
	
	@Test
	public void setgetMaxPlayerWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinPlayer(1);
			g.setMaxPlayer(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getMaxPlayer());
	}
	
	@Test
	public void setMaxPlayerForTwoPlayers( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinPlayer(1);
			g.setMaxPlayer(2);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(2,g.getMaxPlayer());
	}
	
	@Test
	public void setMaxPlayerForOneUniqueNumberOfPlayers( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinPlayer(5);
			g.setMaxPlayer(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getMaxPlayer());
	}
	

	@Test
	public void setMaxPlayerThrowIllegalArgumentExceptionForMaxPlayerLowerThan2( ) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setMaxPlayer(1);
		});
	}
	
	@Test
	public void setgetAgeWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setAge(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getAge());
	}
	
	@Test
	public void setAgeEqualTo3( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setAge(3);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(3,g.getAge());
	}
	
	@Test
	public void setAgeThrowIllegalArgumentExceptionForAgeLowerThan3( ) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setAge(2);
		});
	}
	
	@Test
	public void setgetCreatorNameWithoutError() {
		Game g = null;
		try {
			g = new Game(1,"Monopoly");
			g.setCreatorName("Elisabeth Magie & Charles Darrow");	
		} catch (Exception e) {
			Assertions.fail();
		}
		Assertions.assertEquals("Elisabeth Magie & Charles Darrow", g.getCreatorName());	
	}
	
	@Test
	public void setCreatorNameThrowIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			String s = "";
			for (int i=0;i<50;i++) {
				s += "A";
			}
			g.setCreatorName(s);
		});
	}
	
	@Test
	public void setCreatorNameLength45() {
		Game g = null;
		String s = "";
		for(int i=0;i<45;i++) {
			s+= "A";
		}
		try {
			g = new Game(1,"Monopoly");
			g.setCreatorName(s);
		} catch (Exception e) {
			Assertions.fail();
		}
		Assertions.assertEquals(s,g.getCreatorName());
	}
	
	@Test
	public void setgetMinTimeWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinTime(60);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(60,g.getMinTime());
	}
	
	@Test
	public void setMinTimeThrowIllegalArgumentExceptionForMinTimeLowerThan1() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setMinTime(-10);
		});
	}
	
	@Test
	public void setMinTimeThrowIllegalArgumentExceptionForMinTimeEqualTo0() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setMinTime(0);
		});
	}
	
	@Test
	public void setgetMaxTimeWithoutError( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinTime(1);
			g.setMaxTime(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getMaxTime());
	}
		
	@Test
	public void setMaxTimeForOneUniqueTimeOfGame( ) {
		Game g = null ;
		try {
			g = new Game(1,"Monopoly");
			g.setMinTime(5);
			g.setMaxTime(5);
			} catch (Exception e) {
				Assertions.fail();
			}
		Assertions.assertEquals(5,g.getMaxTime());
	}
	
	@Test
	public void setMaxTimeThrowIllegalArgumentExceptionForMaxTimeLowerMinTime( ) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Game g = new Game(1,"Monopoly");
			g.setMinTime(60);
			g.setMaxTime(50);
		});
	}
	
	
	
}
