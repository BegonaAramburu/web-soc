package com.aramburu.websoc.documents;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.aramburu.websoc.repositories.CenterReactRepository;



public class CenterTest {
	
	private CenterReactRepository centerReactRepository;
	
	@Test
	void testFull() {
		Center center = Center.builder(6666).name("LA VIOLETA").email("cifo_violeta@gencat.cat").phone("66666666").acces("se llega asi").active(true).address("direccion tal").equipment("tal equipamiento").img("imagen").build();
		assertEquals(6666, center.getCode());
		assertEquals("LA VIOLETA", center.getName());
		assertEquals("se llega asi", center.getAcces());
		
	
	}

}
