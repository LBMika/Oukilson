package fr.oukilson.app.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ToolsTest {

//TODO factoriser les tests
    //TODO vérifier l'utilité
    //Testing email verifier
    @Test
    @DisplayName("Test of email checker, valid argument.")
    public void testPatternMatchesTrue(){
        String email = "alphone.daudet@gmail.com";
        Assertions.assertTrue(Tools.patternMatches(email));
    }

    @Test
    @DisplayName("Test of email checker, invalid argument.")
    public void testPatternMatchesFalse(){
        String email = ".alphone.daudet@gmail.com";
        Assertions.assertFalse(Tools.patternMatches(email));
    }

    //Testing length checking method
    @Test
    @DisplayName("Test of length checking method, valid argument.")
    public void testCheckLengthTrue(){
        String string = "test";
        Assertions.assertTrue(Tools.checkLength(string, 10, 1));
    }

    @Test
    @DisplayName("Test of length checking method, invalid arguments.")
    public void testCheckLengthFalse(){
        String string = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";
        int maxLength = 10;
        int minLength = 1;
        Assertions.assertFalse(Tools.checkLength(string, maxLength, minLength));
    }

    @Test
    @DisplayName("Test of length checking method, invalid(too short) argument.")
    public void testCheckLengthFalseToo(){
        String string = "";
        Assertions.assertFalse(Tools.checkLength(string, 10,2));

    }

    //Testing blanks checking method
    @Test
    @DisplayName("Test of blank checking method, valid argument.")
    public void testCheckBlanksTrue(){
        String string = "string";
        Assertions.assertTrue(Tools.checkBlanks(string));
    }

    @Test
    @DisplayName("Test of blank checking method, invalid(has blanks) argument.")
    public void testCheckBlanksFalse(){
        String string = "    aze";
        Assertions.assertFalse(Tools.checkBlanks(string));
    }

    //Testing special character method
    @Test
    @DisplayName("Test of special characters checking method, valid arguments.")
    public void testCheckSpecialTrue(){
        String string = "azomdkaozfkmao";
        Assertions.assertTrue(Tools.checkSpecialCharacters(string));
    }

    @Test
    @DisplayName("Test of special characters checking method, invalid arguments.")
    public void testCheckSpecialFalse(){
        String string = "%âzdoazm!!:";
        Assertions.assertFalse(Tools.checkSpecialCharacters(string));
    }

    //Testing digit checking method
    @Test
    @DisplayName("Test of digit checking method, valid arguments.")
    public void testCheckDigitsTrue(){
        String string = "azdazdazdazd";
        Assertions.assertTrue(Tools.checkDigits(string));
    }

    @Test
    @DisplayName("Test of digit checking method, invalid arguments.")
    public void testCheckDigitsFalse(){
        String string = "addazdazd546584";
        Assertions.assertFalse(Tools.checkDigits(string));
    }

    //Testing string validity method
    @Test
    @DisplayName("Test of validity checking method, valid arguments.")
    public void testCheckValidStringTrue(){
        String string = "test";
        int maxLength = 10;
        int minLength = 1;
        Assertions.assertTrue(Tools.checkValidString(string, maxLength, minLength));
    }

    @Test
    @DisplayName("Test of validity checking method, invalid arguments.")
    public void testCheckValidStringFalse(){
        String string = "azdazd!!;";
        int maxLength = 10;
        int minLength = 2;
        Assertions.assertFalse(Tools.checkValidString(string, maxLength, minLength));
    }

    //Testing email validity method
    @Test
    @DisplayName("Test of email validity checking method, valid arguments.")
    public void testCheckValidEmailStringTrue(){
        String email = "moakzd@email.com";
        int maxLength = 45;
        int minLength = 5;
        Assertions.assertTrue(Tools.checkValidEmailString(email, maxLength, minLength));
    }

    @Test
    @DisplayName("Test of email validity checking method, invalid arguments.")
    public void testCheckValidEmailStringFalse(){
        String email = ".moakzd@email.com";
        int maxLength = 45;
        int minLength = 5;
        Assertions.assertFalse(Tools.checkValidEmailString(email, maxLength, minLength));
    }
    //Testing friend list check
    @Test
    @DisplayName("Test of friend list checking method, valid arguments.")
    public void testOnFriendListFalse(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        Assertions.assertFalse(Tools.onFriendList(mainUser, user));
    }

    @Test
    @DisplayName("Test of friend list checking method, valid argument.")
    public void testOnFriendListTrue(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        mainUser.getFriendList().add(user);
        Assertions.assertTrue(Tools.onFriendList(mainUser, user));
    }

    @Test
    @DisplayName("Test of denied list checking method, valid arguments.")
    public void testOnDeniedListFalse(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        Assertions.assertFalse(Tools.onDeniedList(mainUser, user));
    }

    @Test
    @DisplayName("Test of denied list checking method, valid arguments.")
    public void testOnDeniedListTrue(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        mainUser.getDeniedList().add(user);
        Assertions.assertTrue(Tools.onDeniedList(mainUser, user));
    }

    //Testing isOnList method
    @Test
    @DisplayName("Test of isOnList method, valid arguments.")
    public void testIsOnListFalse(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        Assertions.assertFalse(Tools.isOnList(mainUser, user));
    }

    @Test
    @DisplayName("Test of isOnList method, valid arguments.")
    public void testIsOnListTrue(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        User user = new User("polo", "polo@hotmail.com");
        mainUser.getDeniedList().add(user);
        Assertions.assertTrue(Tools.isOnList(mainUser, user));
    }

    //Testing game lists methods
    @Test
    @DisplayName("Testing onLikedList method, valid arguments.")
    public void testOnLikedListFalse(){
        User mainUser = new User("marco", "marco@email.com", "marc", "paul");
        GameOld game = new GameOld("jean");
        Assertions.assertFalse(Tools.onLikedList(mainUser, game));
    }

    @Test
    @DisplayName("Testing onLikedList method, valid arguments.")
    public void testOnLikedListTrue(){
        User mainUser = new User("marco", "marco@email.com", "marc", "paul");
        GameOld game = new GameOld("jean");
        mainUser.getUserLikeList().add(game);
        Assertions.assertTrue(Tools.onLikedList(mainUser, game));
    }

    @Test
    @DisplayName("Testing onOwnedList method, valid arguments.")
    public void testOnOwnedListFalse(){
        User mainUser = new User("marco", "marco@email.com", "marc", "paul");
        GameOld game = new GameOld("jean");
        Assertions.assertFalse(Tools.onOwnedList(mainUser, game));
    }

    @Test
    @DisplayName("Testing onLikedList method, valid arguments.")
    public void testOnOwnedListTrue(){
        User mainUser = new User("marco", "marco@email.com", "marc", "paul");
        GameOld game = new GameOld("jean");
        mainUser.getUserGameList().add(game);
        Assertions.assertTrue(Tools.onOwnedList(mainUser, game));
    }

    //Testing isOnGameList method
    @Test
    @DisplayName("Test of isOnGameList method, valid arguments.")
    public void testIsOnGameListFalse(){
        User mainUser = new User("marco","marco@hotmail.com", "marc", "paul");
        GameOld game = new GameOld("polo");
        Assertions.assertFalse(Tools.isOnGameList(mainUser, game));
    }

    @Test
    @DisplayName("Test of isOnList method, valid arguments.")
    public void testIsOnGameListTrue() {
        User mainUser = new User("marco", "marco@hotmail.com", "marc", "paul");
        GameOld game = new GameOld("polo");
        mainUser.getUserGameList().add(game);
        Assertions.assertTrue(Tools.isOnGameList(mainUser, game));
    }
}
