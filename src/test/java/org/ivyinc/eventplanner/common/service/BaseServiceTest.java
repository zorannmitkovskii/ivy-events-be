package org.ivyinc.eventplanner.common.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

/**
 * Base class for service unit tests that use Mockito.
 */
public abstract class BaseServiceTest {

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
}
