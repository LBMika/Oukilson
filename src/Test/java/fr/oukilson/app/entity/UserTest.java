package fr.oukilson.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    //Tests of nickname getter
    @Test
    @DisplayName("Test of nickname getter with a valid argument.")
    public void testNicknameGetterNoException(){
        User user = new User();
        user.setNickname("Marc");
        Assertions.assertEquals(user.getNickname(), "Marc");
    }

    //testing email getter
    @Test
    @DisplayName("Test of email getter with a valid argument.")
    public void testEmailGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com");
        Assertions.assertEquals(user.getEmail(), "marc@hotmail.com");
    }

    //Testing first name getter
    @Test
    @DisplayName("Test of first getter with a valid argument.")
    public void testFirstNameGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com", "marcooooo");
        Assertions.assertEquals(user.getFirstName(), "marcooooo");
    }

    //Testing last name getter
    @Test
    @DisplayName("Test of last getter with a valid argument.")
    public void testLastNameGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Assertions.assertEquals(user.getLastName(), "Penaud");
    }

    //Testing UserList methods
    @Test
    @DisplayName("Test of addUserToFriendList method, valid argument.")
    public void testAddUserToFriendListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertEquals(mainUser.getFriendList().get(0).getNickname(), user.getNickname());
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, valid argument.")
    public void testAddUserToDeniedListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertEquals(mainUser.getDeniedList().get(0).getNickname(), user.getNickname());
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }

    @Test
    @DisplayName("Test of removeUserToFriendList method, valid argument.")
    public void testRemoveUserToFriendListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        User otherUser = new User("paul", "jpaukl@gmail.com");
        mainUser.addUserToFriendList(user);
        mainUser.removeUserFromFriendList(user);
        mainUser.addUserToFriendList(otherUser);
        Assertions.assertEquals(mainUser.getFriendList().get(0),otherUser);
    }

    @Test
    @DisplayName("Test of removeUserToFriendList method, invalid argument.")
    public void testRemoveUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromFriendList(user));
    }

    @Test
    @DisplayName("Test of removeUserToDeniedList method, valid argument.")
    public void testRemoveUserToDeniedListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        User otherUser = new User("paul", "jpaukl@gmail.com");
        mainUser.addUserToDeniedList(user);
        mainUser.removeUserFromDeniedList(user);
        mainUser.addUserToDeniedList(otherUser);
        Assertions.assertEquals(mainUser.getDeniedList().get(0),otherUser);
    }

    @Test
    @DisplayName("Test of removeUserToDeniedList method, invalid argument.")
    public void testRemovedUserToDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromDeniedList(user));
    }
}
