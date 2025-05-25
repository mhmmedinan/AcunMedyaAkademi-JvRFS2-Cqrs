package com.rentacarcqrs.common.application.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest extends AuthenticatedRequest {
    List<String> getRoles();
}
