package com.mytests.pages

import geb.Page

class ShortableTablesPage extends Page {
    static url = "https://the-internet.herokuapp.com/tables"

    static at = {
        waitFor(30){
            browser.currentUrl.contains("table")
        }
    }

    static content = {
        editButton(wait: true) {$(id: "table1").find("tr").find("td").find("a", text: containsWord("edit")).first()}
        deleteButton(wait: true) {$(id: "table1").find("tr").find("td").find("a", text: containsWord("delete")).first()}
    }
}
