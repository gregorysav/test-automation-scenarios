package com.mytests.tests

import com.mytests.pages.StatusCodePage
import geb.spock.GebSpec

class StatusCodeTest extends GebSpec {
    def "Check all status codes"() {
        given: "User is at the correct page"
            def statusCodes = to StatusCodePage

        when: "User clicks on 200 status code"
            statusCodes.statusCodeOption("200").click()

        then: "Redirects to the 200 status code page"
            statusCodes.nextPageHas("This page returned a 200 status code.")

        when: "User goes back on the page with the statuses"
            statusCodes.goToPreviousPage.click()

        and: "User clicks on 301 status code"
            statusCodes.statusCodeOption("301").click()

        then: "Redirects to the 301 status code page"
            statusCodes.nextPageHas("This page returned a 301 status code.")

        when: "User goes back on the page with the statuses"
            statusCodes.goToPreviousPage.click()

        and: "User clicks on 404 status code"
            statusCodes.statusCodeOption("404").click()

        then: "Redirects to the 404 status code page"
            statusCodes.nextPageHas("This page returned a 404 status code.")

        when: "User goes back on the page with the statuses"
            statusCodes.goToPreviousPage.click()

        and: "User clicks on 500 status code"
            statusCodes.statusCodeOption("500").click()

        then: "Redirects to the 500 status code page"
            statusCodes.nextPageHas("This page returned a 500 status code.")

    }
}
