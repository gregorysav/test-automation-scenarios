package com.mytests.pages

import geb.Page

class StatusCodePage extends Page {
    static url = "https://the-internet.herokuapp.com/status_codes"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("status_codes")
        }
    }

    static content = {
        statusCodeOption(wait: true) { String option -> $("li").find("a", text: containsWord(option)) }
        nextPageHas(wait: true) { String option -> $("p", text: containsWord(option)) }
        goToPreviousPage(wait: true) {$("p").find("a", text: containsWord("here"))}
    }
}
