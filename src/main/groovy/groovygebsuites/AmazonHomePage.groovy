package groovygebsuites

import geb.Page

class AmazonHomePage extends Page {
    static url = "https://www.amazon.com/"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("amazon")
        }
    }

    static content = {
        searchInput (wait: true) {$("id": "twotabsearchtextbox")}
        searchButton (wait: true) {$("value": "Go")}
        searchFromDropDown (wait: true) {$("id": "searchDropdownBox")}
        searchFromDropDownOption (wait: true) { String option -> $("option", text: containsWord(option))}
        navbarLinks (wait: true) { String linkOption -> $("id": "nav-xshop").find("a", text: containsWord(linkOption))}
        dealsAndPromotions (wait: true) {$("id": "fst-hybrid-dynamic-h1").find("h1", text: containsWord("Deals and Promotions"))}
    }
}
