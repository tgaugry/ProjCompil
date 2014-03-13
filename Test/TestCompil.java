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
		TabIdent ti = new TabIdent();

		ti.rangeIdent("e", new IdConst(YakaConstants.ENTIER, 42));
		ti.rangeIdent("v", new IdVar(YakaConstants.BOOLEEN));
		ti.rangeIdent("b", new IdConst(YakaConstants.BOOLEEN, YakaConstants.FAUX));
		
		assertTrue(ti.existeIdent("e"));
		assertFalse(ti.existeIdent("a"));
		
		assertEquals(ti.chercherIdent("e").getValOuOffset(), 42);
		assertEquals(ti.chercherIdent("v").getValOuOffset(), -2);
		assertEquals(ti.chercherIdent("v").getType(), YakaConstants.BOOLEEN);
		assertEquals(ti.chercherIdent("b").getType(), YakaConstants.BOOLEEN);
	}
	

	@Test
	public void testDeclaration() {
		Yaka.tabIdent = new TabIdent();
		Yaka.declaration = new Declaration();
		//Constantes
		Yaka.declaration.declConst("aa", YakaConstants.ENTIER, 10);
		Yaka.declaration.declConst("ba", YakaConstants.BOOLEEN, YakaConstants.VRAI);
		assertEquals(Yaka.tabIdent.chercherIdent("aa").getValOuOffset(), 10);
		assertEquals(Yaka.tabIdent.chercherIdent("aa").getType(), YakaConstants.ENTIER);
		assertEquals(Yaka.tabIdent.chercherIdent("ba").getValOuOffset(), YakaConstants.VRAI);
		assertEquals(Yaka.tabIdent.chercherIdent("ba").getType(), YakaConstants.BOOLEEN);
		//Variables
		Yaka.declaration.declVar("c1", YakaConstants.ENTIER);
		Yaka.declaration.declVar("b1", YakaConstants.BOOLEEN);
		assertEquals(Yaka.tabIdent.chercherIdent("c1").getValOuOffset(), -2);
		assertEquals(Yaka.tabIdent.chercherIdent("c1").getType(), YakaConstants.ENTIER);
		assertEquals(Yaka.tabIdent.chercherIdent("b1").getValOuOffset(), -4);
		assertEquals(Yaka.tabIdent.chercherIdent("b1").getType(), YakaConstants.BOOLEEN);
		
	}
}

