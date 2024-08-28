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

package com.ericsson.oss.mediation.mplane.ejb

import com.ericsson.cds.cdi.support.rule.ObjectUnderTest
import com.ericsson.cds.cdi.support.spock.CdiSpecification

/**
 * Test class for {@link ORUSoftwarePackageVersionListener}
 */
class ORUSoftwarePackageVersionListenerSpec extends CdiSpecification {

    @ObjectUnderTest
    ORUSoftwarePackageVersionListener oruSoftwarePackageVersionListener

    def "When the O-RU Software Package Version Listener is updated the parameter changes in the system"() {
        given: "A version for PIB"
            oruSoftwarePackageVersionListener.oruSoftwarePackages = "1.1"
            assert oruSoftwarePackageVersionListener.getORuSoftwarePackageVersion() == "1.1"

        when: "Listener detects update to package version and applies it"
            oruSoftwarePackageVersionListener.listenForORuSoftwarePackageVersion("2.0")

        then: "Software package version is updated to new value"
            assert oruSoftwarePackageVersionListener.getORuSoftwarePackageVersion() == "2.0"
    }
}