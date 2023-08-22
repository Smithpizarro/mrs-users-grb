package pe.business.app.users.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Constant {


    public final static String FIND_ALL = "FIND_ALL";

    public static final String CODE_POTENCIAL="7003";
    public static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


    public static final String CODE_EMAIL_FORMAT =
            "7007";

    public static final String CODE_PASSWORD_FORMAT =
            "7008";


}
