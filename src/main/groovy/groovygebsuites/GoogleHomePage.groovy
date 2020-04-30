package groovygebsuites

import geb.Page

class GoogleHomePage extends Page {
    static url = "https://www.google.gr/"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("google")
        }
    }

    static content = {
        googleSearchInput (wait: true) {$("name": "q")}
    }
}
