/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2024
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/

package com.ericsson.oss.mediation.mplane.ejb;

import com.ericsson.oss.itpf.sdk.config.annotation.ConfigurationChangeNotification;
import com.ericsson.oss.itpf.sdk.config.annotation.Configured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Listener for Configuration parameter (PIB) changes.
 */
@ApplicationScoped
@SuppressWarnings("PMD")
public class ORUSoftwarePackageVersionListener {

    public static final String O_RU_SOFTWARE_PACKAGES_PIB = "O_RU_Software_Packages";

    private static final Logger logger = LoggerFactory.getLogger(ORUSoftwarePackageVersionListener.class);

    @Inject
    @Configured(propertyName = O_RU_SOFTWARE_PACKAGES_PIB)
    private String oruSoftwarePackages;

    void listenForORuSoftwarePackageVersion(
            @Observes @ConfigurationChangeNotification(propertyName = O_RU_SOFTWARE_PACKAGES_PIB) final String newORuSoftwarePackageVersion) {
        logger.info("{} parameter change listener invoked. New value for the parameter is: {}", O_RU_SOFTWARE_PACKAGES_PIB,
                newORuSoftwarePackageVersion);
        oruSoftwarePackages = newORuSoftwarePackageVersion;
    }

    public String getORuSoftwarePackageVersion() {
        return oruSoftwarePackages;
    }

}
