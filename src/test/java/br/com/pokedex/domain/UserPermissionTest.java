package br.com.pokedex.domain;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.feature.UserPermissionScenarioFactory;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class UserPermissionTest {
    
    @Test
    public void EqualAndHashCode_ExpectedEquals(){
        UserPermission x=UserPermissionScenarioFactory.USER_PERMISSION;
        UserPermission y=UserPermissionScenarioFactory.USER_NEW;

        assertNotSame(x, y);
		assertEquals(x.hashCode(),y.hashCode());
		assertEquals(x.toString(),y.toString());
		assertTrue(x.hashCode()==y.hashCode());
		assertTrue(x.equals(y));
    }

    @Test
    public void simpleEqualsContact(){
        EqualsVerifier.simple().forClass(UserPermission.class).suppress(Warning.SURROGATE_KEY);
    }

    @Test
    public void userPermission_ExpectedBuild(){
        assertNotNull(UserPermissionScenarioFactory.USER_BUILDER);
    }

    @Test
    public void userPermission_ExpectedNoArgs(){
        new UserPermission();
    }

    @Test
    public void userPermission_ExpectedSetObjects(){
        assertNotNull(UserPermissionScenarioFactory.USER_SET);
    }

    @Test
    public void userPermission_ExpectedGetObjects(){
        assertNotNull(UserPermissionScenarioFactory.USER_GET);
    }

    @Test
    public void userPermission_UserPermission_toString() {
        UserPermission.UserPermissionBuilder builder = UserPermission.builder();
        String expected = UserPermission.builder().toString();
        assertEquals(expected, builder.toString());
    }
}
