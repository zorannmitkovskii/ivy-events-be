package org.ivyinc.eventplanner.common.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Base class for controller slice tests using MockMvc.
 * Subclasses should provide their own slice annotations such as @WebMvcTest
 * and override getBasePath() if they want a shared API root constant.
 */
public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    /**
     * Override to provide the base API path for the controller under test.
     */
    protected abstract String getBasePath();
}
