package it.sevenbits.thirdworkshop;

import it.sevenbits.thirdworkshop.User.Exceptions.UserManagerException;
import it.sevenbits.thirdworkshop.User.Interfaces.ICollection;
import it.sevenbits.thirdworkshop.User.User;
import it.sevenbits.thirdworkshop.User.UserManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class UserManagerTest {
    private ICollection mockCollection;
    private UserManager userManager;

    @Before
    public void setUp() {
        mockCollection = mock(ICollection.class);
        userManager = new UserManager(mockCollection);
    }
    @Test
    public void getUserByIndexTest() throws UserManagerException, IOException {
        when(mockCollection.get(0)).thenReturn(new User("Neox", "default"));
        assertEquals("Wrong name", "Neox", userManager.getUserByIndex(0).getName());
        assertEquals("Wrong role", "default", userManager.getUserByIndex(0).getRole());
    }
    @Test
    public void createDefaultTest() throws UserManagerException, IOException {
        doAnswer(invocationOnMock -> {
            User user = invocationOnMock.getArgument(0);
            assertEquals("Wrong name", "Neox", user.getName());
            assertEquals("Wrong role", "default", user.getRole());
            return null;
        }).when(mockCollection).add(any(User.class));
        userManager.createDefault("Neox");
    }
    @Test (expected = UserManagerException.class)
    public void getUserByIndexTestException() throws IOException, UserManagerException {
        when(mockCollection.get(2)).thenThrow(new IOException("User with this id doesn't found"));
        userManager.getUserByIndex(2);
    }
    @Test (expected = UserManagerException.class)
    public void createDefaultTestException() throws IOException, UserManagerException {
        doThrow(new IOException("User can't added")).when(mockCollection).add(any(User.class));
        userManager.createDefault("Neox");
    }
}
