package com.mytests.pages

import geb.Page

class TyposPage extends Page {
    static url = "https://the-internet.herokuapp.com/"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("herokuapp")
        }
    }

    static content = {
        typosLink(wait: true) { $("li").find("a", text: "Typos") }
        shownText(wait: true) {$(class: "example")}
    }

    boolean checkForTypos() {
        if(shownText.text().equals("Typos\nThis example demonstrates a typo being introduced. It does it randomly on each page load.\nSometimes you'll see a typo, other times you won't.")) {
            return true;
        }else {
            return false
        }
    }
}
