package com.mytests.tests

import com.mytests.pages.ForgotPasswordPage
import geb.spock.GebSpec

class ForgotPasswordTest extends GebSpec {
    def "Retrieve password functionality"() {
        given: "User is at the correct page"
            def forgotPassword = to ForgotPasswordPage

        when: "User types his email"
            forgotPassword.inputField.value("g@g.com")

        and: "Clicks on button"
            forgotPassword.retrieveButton.click()

        then: "User is at the retrieve password page"
            forgotPassword.emailSent.text().contains("Your e-mail's been sent!")
    }
}
