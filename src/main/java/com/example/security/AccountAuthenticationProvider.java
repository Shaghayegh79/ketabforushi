package com.example.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
//@CrossOrigin
public class AccountAuthenticationProvider
        extends AbstractUserDetailsAuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken token)
                    throws AuthenticationException {
        logger.info("> additionalAuthenticationChecks");
       
        if (token.getCredentials() == null
                || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }
//System.out.print("???????????? "+ passwordEncoder.matches((CharSequence) token.getCredentials(), userDetails.getPassword()));
//BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();    
	if ((passwordEncoder.matches((CharSequence) token.getCredentials(), userDetails.getPassword())) == false)
	{
		throw new BadCredentialsException("Invalid credentials.");
    }

        logger.info("< additionalAuthenticationChecks");
    }

    @Override
    protected UserDetails retrieveUser(String username,
            UsernamePasswordAuthenticationToken token)
                    throws AuthenticationException {
        logger.info("> retrieveUser");

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        logger.info("< retrieveUser");
        return userDetails;
    }

}
