package com.mytests.pages

import geb.Page

class ForgotPasswordPage extends Page {
    static url = "https://the-internet.herokuapp.com/forgot_password"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("forgot_password")
        }
    }

    static content = {
        inputField(wait: true) {$(name: "email")}
        retrieveButton(wait: true) {$(id: "form_submit")}
        emailSent(wait: true) {$(id: "content")}
    }
}
