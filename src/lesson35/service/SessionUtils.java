package lesson35.service;

import lesson35.exception.BadRequestException;
import lesson35.model.User;
import lesson35.model.UserType;

public class SessionUtils {

    private static User loggedInUser = null;

    public static void setLoggedInUser(User loggedInUser) {
        SessionUtils.loggedInUser = loggedInUser;
    }

    public static boolean isAuthorized() throws BadRequestException {
        if (loggedInUser != null) {
            return true;
        }
        throw new BadRequestException("error, you need to log in to your account first, then you can use search.");
    }

    public static boolean isAdminAuthorized() throws BadRequestException {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN) {
            return true;
        }
        throw new BadRequestException("error: the user is not an admin.");
    }


}
