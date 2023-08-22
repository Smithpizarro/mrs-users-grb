package pe.business.app.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.business.app.users.config.JwtRequestFilter;
import pe.business.app.users.config.JwtTokenUtil;
import pe.business.app.users.controller.exception.ServiceException;
import pe.business.app.users.model.TransactionRs;
import pe.business.app.users.model.UserRq;
import pe.business.app.users.service.UsersService;
import pe.business.app.users.util.Constant;

import pe.business.app.users.model.UserRs;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/grb/users")
@Validated
public class UsersController {

    @Autowired
    UsersService usersService;


    @Autowired
    private   JwtTokenUtil jwtTokenUtil;

    private static final Pattern patternEmail = Pattern.compile(Constant.EMAIL_PATTERN);

    @PostMapping
    public ResponseEntity<TransactionRs<UserRs>> createUser(
            @Valid @RequestBody UserRq userRq, BindingResult result) {
        TransactionRs<UserRs> response = new TransactionRs<UserRs>();
        List<UserRs> students =  new ArrayList<>();
        if(!isValidEmail(userRq.getEmail())){
            throw new ServiceException(Constant.CODE_EMAIL_FORMAT);
        }
        if(!isValidPassword(userRq.getPassword())){
            throw new ServiceException(Constant.CODE_PASSWORD_FORMAT);
        }
        UserRs userRs = usersService.createUser(userRq);
        response.setRespuesta(userRs);
        response.isSuccess();

        return  ResponseEntity.status( HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<TransactionRs<List<UserRs>>> listUser( ){
        TransactionRs<List<UserRs>> response = new TransactionRs<List<UserRs>>();
        List<UserRs> prices =  new ArrayList<>();
         prices = usersService.findUsers();

        if (prices.isEmpty()) {
            throw new ServiceException(Constant.CODE_POTENCIAL);
        }
        response.setRespuesta(prices);
        response.isSuccess();
        return  ResponseEntity.status( HttpStatus.OK).body(response);
    }

    public static boolean isValidEmail(final String email) {
        Matcher matcher = patternEmail.matcher(email);
        return matcher.matches();
    }


    public  boolean isValidPassword(final String password) {
        Pattern patternPassword = Pattern.compile(jwtTokenUtil.getPatternpass());
        Matcher matcher = patternPassword.matcher(password);
        return matcher.matches();
    }
}
