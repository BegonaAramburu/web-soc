package com.aramburu.websoc.documents;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class CenterTest {
	
	@Test
	void testFull() {
		Center center = Center.builder("1").name("LA VIOLETA").email("cifo_violeta@gencat.cat").phone("66666666").acces("se llega asi").active(true).address("direccion tal").equipment("tal equipamiento").img("imagen").build();
		assertEquals("1", center.getId());
		assertEquals("LA VIOLETA", center.getName());
		assertEquals("se llega asi", center.getAcces());
	
	}

}
