package com.mytests.tests

import com.mytests.pages.TyposPage
import geb.spock.GebSpec

class TyposPageTest extends GebSpec {
    def "Check all status codes"() {
        given: "User is at the main page"
        def typosPage = to TyposPage

        when: "User clicks on typos option"
            typosPage.typosLink.click()

        then: "Check the shown message"
            if (typosPage.checkForTypos()) {
                System.out.println("Text is the same")
            } else {
                System.out.println("Text is not the same")
            }
    }
}