package no.hvl.dat100.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import no.hvl.dat100.oppgave2.*;

public class TestBilde {
	

	@Test
	public void testConstructor1() {
		Bilde bilde = new Bilde(1,"Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
		
		assertEquals("Ole Olsen",bilde.getBruker());
		assertEquals(1, bilde.getId());
		assertEquals("23-10",bilde.getDato());
		assertEquals(0, bilde.getLikes());
		assertEquals("et bilde",bilde.getTekst());
		assertEquals("http://www.picture.com/oo.jpg",bilde.getUrl());
	}

	@Test
	public void testConstructor2() {
		Bilde bilde = new Bilde(1,"Ole Olsen", "23-10",7,"et bilde","http://www.picture.com/oo.jpg");
		
		assertEquals("Ole Olsen",bilde.getBruker());
		assertEquals(1, bilde.getId());
		assertEquals("23-10",bilde.getDato());
		assertEquals(7, bilde.getLikes());
		assertEquals("et bilde",bilde.getTekst());
		assertEquals("http://www.picture.com/oo.jpg",bilde.getUrl());
	}

	@Test
	public void testSet() {
		Bilde bilde = new Bilde(1,"Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
	
		bilde.setUrl("http://www.picture.com/new.jpg");
		
		assertEquals("http://www.picture.com/new.jpg",bilde.getUrl());
	}

	@Test
	public void testToString() {
		Bilde bilde = new Bilde(1,"Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
		
		String str = "BILDE\n1\nOle Olsen\n23-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n";
		
		assertEquals(str,bilde.toString(),str);
	}
}
