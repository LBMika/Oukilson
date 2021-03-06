package fr.oukilson.app.entity;


import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Pattern;

public class Tools {


    //TODO ne pas renvoyer d'exceptions, renvoyer un "prédicat" -> vrai ou faux
    /**
     * method to check the validity of the email's format
     * @param emailAddress user's email
     * @return true if email is valid
     */
    public static boolean patternMatches(String emailAddress){
        boolean isMatch = false;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       if (Pattern.compile(regexPattern).matcher(emailAddress).matches()) {
           isMatch = true;
        }
      return isMatch;
    }

    /**
     * checks if length of param is valid( 0 < param < 46)
     * @param string string input by user(names, emails, etc)
     * @return validity of string
     */
    public static boolean checkLength(String string, int maxLength, int minLength){
        boolean isValid = string.length() <= maxLength && string.length() >= minLength;
        return isValid;
    }
    
    /**
     * checks if length of param is valid( 0 < param < 46)
     * @param string string input by user(names, emails, etc)
     * @return validity of string
     */
    public static boolean checkLength(String string, int maxLength){
        boolean isValid = string.length() <= maxLength;
        return isValid;
    }

    /**
     * Checks if user input contains blank spaces
     * @param string user's name
     * @return true if the name is valid
     */
    public static boolean checkBlanks(String string){
        boolean isValid = !string.contains(" ");
        return isValid;
    }

    /**
     * checks for special characters in user input
     * @param string user input
     * @return true if the string is valid
     */
    public static boolean checkSpecialCharacters(String string){
        String regexPattern = "[`~!@#$%^&*()_+[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]";
        boolean isValid = !Pattern.compile(regexPattern).matcher(string).find();
        return isValid;
    }

    /**
     * checks if there are any illegal digits in the string
     * @param string user input
     * @return true if string is valid
     */
    public static boolean checkDigits(String string){
        String regexPattern = "[0-9]";
        boolean isValid = !Pattern.compile(regexPattern).matcher(string).find();
        return isValid;
    }


    //TODO allow particles(Cecile De France)

    /**
     * check overall validity of string
     * @param string string to be checked
     * @param maxLength max acceptable length of string (in database)
     * @param minLength min acceptable length of string
     * @return true if string is valid
     */
    public static boolean checkValidString(String string, int maxLength, int minLength){
        boolean isValid = checkLength(string, maxLength, minLength) && checkBlanks(string) && checkSpecialCharacters(string);
        return isValid;
    }

    /**
     * checks for string validity
     * @param string user input
     * @param maxLength max length allowed for user input
     * @param minLength min acceptable length of string
     * @return true if input is valid
     */
    public static boolean checkValidEmailString(String string, int maxLength, int minLength) throws IllegalArgumentException{
        boolean isValid = patternMatches(string) && checkLength(string, maxLength, minLength) && checkBlanks(string);
        return isValid;
    }
    /**
     * checks if user is already on friend list
     * @param mainUser main user, trying to add a friend to list
     * @param otherUser potential friend
     * @return is already on friend list y/n
     */
    public static boolean onFriendList (User mainUser, User otherUser){
        boolean isOnList = false;
            for (User user : mainUser.getFriendList()) {
                if (otherUser.getNickname().equals(user.getNickname())) {
                    isOnList = true;
                    break;
                }
            }
        return isOnList;
    }
    /**
     * checks if user is already on denied list
     * @param mainUser main user, trying to add a denied to list
     * @param otherUser potential denied
     * @return is already on denied list y/n
     */
    public static boolean onDeniedList (User mainUser, User otherUser){
        boolean isOnList = false;
        for (User user : mainUser.getDeniedList()) {
            if (otherUser.getNickname().equals(user.getNickname())) {
                isOnList = true;
                break;
            }
        }
       return isOnList;
    }

    /**
     * checks if a game is already on liked list
     * @param mainUser main user, trying to add a game to list
     * @param likedGame potential liked game
     * @return is already on liked list y/n
     */
    public static boolean onLikedList (User mainUser, GameOld likedGame){
        boolean isOnList = false;
        for (GameOld game : mainUser.getUserLikeList()) {
            if (game.getName().equals(likedGame.getName())) {
                isOnList = true;
                break;
            }
         return isOnList;
      }


    /**
     * compares a string of characters to a given regex and returns matching status
     * @param regex string of characters that define the accepted or *not* accepted list of chars
     * @param string string of characters we wish to check the individual characters of
     * @return true if the string is valid(conform to the regex), false if it isn't
     */
    public static boolean checkRegex(String regex, String string){
        boolean isValid = Pattern.compile(regex).matcher(string).find();
        return isValid;
    }


    /**
     * function checks if a user is already on a list by using its UUID
     * @param user user to check
     * @param map list of users to verify
     * @return true if user is on list, false otherwise
     */
    public static boolean userOnList(User user, HashMap map){
        boolean isOnList = false;
        if(map.containsKey(user.getUUID())){
            isOnList = true;
        }
        return isOnList;
    }

    /**

     * checks if a game is already on owned list
     * @param mainUser main user, trying to add a game to list
     * @param ownedGame potential owned game
     * @return is already on owned list y/n
     */
    public static boolean onOwnedList (User mainUser, GameOld ownedGame){
        boolean isOnList = false;
        for (GameOld game : mainUser.getUserGameList()) {
            if (game.getName().equals(ownedGame.getName())) {
                isOnList = true;
                break;
            }
        }
        return isOnList;
    }
    /**
     * check if user is on list
     * @param mainUser list owner
     * @param user potentially on list
     * @return if already on list
     * @throws IllegalArgumentException already on list
     */
    public static boolean isOnList( User mainUser, User user){
        boolean isOnList = onDeniedList(mainUser, user) || onFriendList(mainUser, user);
        return isOnList;
    }

    /**
     * checks if a game is already on the user's lists
     * @param mainUser user whose lists we are checking
     * @param game game the user wishes to add to his list
     * @return true if the game is already on a list, false if not
     */
    public static boolean isOnGameList(User mainUser, GameOld game) {
        return onLikedList(mainUser, game) || onOwnedList(mainUser, game);
    }

      
     * function checks if game is already on a list by using its UUID
     * @param game game to check
     * @param map list of games to verify
     * @return true if game is on list, false otherwise
     */
    public static boolean gameOnList(Game game, HashMap map){
        boolean isOnList = false;
        if(map.containsKey(game.getUUID())){
            isOnList = true;
        }
        return isOnList;
    }

}
