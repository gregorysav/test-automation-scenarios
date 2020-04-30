package com.mytests.tests

import com.mytests.pages.ShortableTablesPage
import geb.spock.GebSpec

class ShortableTableTest extends GebSpec {
    def "Check buttons functionality"() {
        given: "User is at the correct page"
            def shortableTable = to ShortableTablesPage

        when: "User clicks on edit link"
            shortableTable.editButton.click()

        then: "URL changes"
            currentUrl.contains("#edit")

        and: "Loads first page"
            at ShortableTablesPage

        when: "User clicks on delete link"
            shortableTable.deleteButton.click()

        then: "URL changes"
            currentUrl.contains("#delete")
    }
}
