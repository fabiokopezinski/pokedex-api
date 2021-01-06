package br.com.pokedex.domain;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.feature.PermissionScenarioFactory;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class PermissionTest {
    
    @Test
    public void EqualAndHashCode_ExpectedEquals(){
        Permission x=PermissionScenarioFactory.PERMISSION;
        Permission y=PermissionScenarioFactory.PERMISSION_NEW;

        assertNotSame(x, y);
		assertEquals(x.hashCode(),y.hashCode());
		assertEquals(x.toString(),y.toString());
		assertTrue(x.hashCode()==y.hashCode());
		assertTrue(x.equals(y));
    }

    @Test
    public void simpleEqualsContact(){
        EqualsVerifier.simple().forClass(Permission.class).suppress(Warning.SURROGATE_KEY);
    }

    @Test
    public void permission_ExpectedBuild(){
        assertNotNull(PermissionScenarioFactory.PERMISSION_BUILDER);
    }

    @Test
    public void permission_ExpectedNoArgs(){
        new Permission();
    }

    @Test
    public void permission_ExpectedSetObjects(){
        assertNotNull(PermissionScenarioFactory.PERMISSION_SET);
    }

    @Test
    public void permission_ExpectedGetObjects(){
        assertNotNull(PermissionScenarioFactory.PERMISSION_GET);
    }

    @Test
    public void permission_Permission_toString(){
        Permission.PermissionBuilder builder=Permission.builder();
        String expected=Permission.builder().toString();
        assertEquals(expected, builder.toString());
    }
}
