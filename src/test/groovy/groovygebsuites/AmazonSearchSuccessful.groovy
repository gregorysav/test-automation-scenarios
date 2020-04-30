package groovygebsuites

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class AmazonSearchSuccessful extends GebReportingSpec {
    def "Open amazon website and make successful search and find today's deals"() {
        given: "User visits Google home page"
            def googlePage = to GoogleHomePage

        when: "User types amazon"
            googlePage.googleSearchInput.value(searchOnGoogle)

        and: "User clicks enter for search"
            googlePage.googleSearchInput << Keys.ENTER

        then: "All amazon related results are shown"
            assert currentUrl.contains(searchOnGoogleExpectedResult)

        and: "User visits amazon website"
            def amazonPage = to AmazonHomePage

        when: "User types to search for laptop"
            waitFor {
                amazonPage.searchInput.value(searchOnAmazon)
            }

        and: "User selects from dropdown menu"
            waitFor {
                amazonPage.searchFromDropDown.click()
            }
            amazonPage.searchFromDropDownOption(dropdownOption)

        and: "User clicks search button"
            amazonPage.searchButton.click()

        then: "User redirects to the laptop results page"
           assert currentUrl.contains(searchOnAmazonExpectedResult)

        when: "User clicks on Today's Deals link"
            amazonPage.navbarLinks(linkToClick).click()

        then: "User redirects on the Today's Deals page"
            assert amazonPage.dealsAndPromotions.isDisplayed()

        where:
        searchOnGoogle | searchOnGoogleExpectedResult | searchOnAmazon | dropdownOption | searchOnAmazonExpectedResult | linkToClick
           "amazon"    |          "amazon"            |   "laptop"     |  "Computers"   |         "laptop"             |    "Today's Deals"
//           "amazon"    |          "amazon"            |   "laptop"     |  "Wrong value"   |         "laptop"
    }
}
