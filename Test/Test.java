package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Compil.*;

public class TestCompil {
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void testTabIdent() {
		TabIdent ti = new TabIdent(12);

		ti.rangeIdent("e", new IdConst(42));
		ti.rangeIdent("v", new IdVar(Ident.TypeVar.BOOL));
		ti.rangeIdent("b", new IdConst(false));
		
		assertTrue(ti.existeIdent("e"));
		assertFalse(ti.existeIdent("a"));
		
		assertEquals(ti.chercherIdent("e").getValOuOffset(), 42);
		assertEquals(ti.chercherIdent("v").getValOuOffset(), -2);
		assertEquals(ti.chercherIdent("v").getType(), Ident.TypeVar.BOOL);
		assertEquals(ti.chercherIdent("b").getType(), Ident.TypeVar.BOOL);
	}
}

