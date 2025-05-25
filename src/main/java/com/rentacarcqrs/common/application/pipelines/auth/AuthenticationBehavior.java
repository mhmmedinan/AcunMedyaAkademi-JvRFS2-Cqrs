package com.rentacarcqrs.common.application.pipelines.auth;

import an.awesome.pipelinr.Command;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.AuthenticationException;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.AuthorizationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationBehavior  implements Command.Middleware {
    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        if(command instanceof AuthenticatedRequest){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null || !authentication.isAuthenticated()){
                throw new AuthenticationException("Failed");
            }
            if (command instanceof AuthorizedRequest){
                List<String> roles = ((AuthorizedRequest) command).getRoles();

                boolean hasAnyMatch = authentication.getAuthorities().
                        stream().anyMatch(i->roles.stream().anyMatch(x->x.equalsIgnoreCase(i.getAuthority())));
                if(!hasAnyMatch)
                    throw new AuthorizationException("Failed");
            }
        }
      return next.invoke();

    }
}
