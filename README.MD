# API Tests
##run tests:
- execute `./gradlew api-tests:clean api-tests:test`

##generate Allure report:
- set `api-tests/src/test/resources/api_test.properties` property `logging.allure.enable=true`
- execute `./gradlew api-tests:allureReport`
- report will be generated in `ui-tests/build/reports/allure-report`
- open `index.html` file in browser

##generate Swagger Coverage report
- set `api-tests/src/test/resources/test.properties` property `swagger.coverage.enable=true`
- execute `sh /api-tests/generate_swagger_coverage.sh`
- report will be generated in `api-tests/swagger-coverage-report.html`

#UI Tests
## run tests
- set required properties in `ui-tests/src/test/resources/ui_test.properties`
- execute `./gradlew ui-tests:clean ui-tests:test`

###Local run
- set property `ui-tests/src/test/resources/ui_test.properties` `browser.remote.enable=false`

###Remote run
- set properties `ui-tests/src/test/resources/ui_test.properties` `browser.remote.enable=true`
- specify url where Selenium server hosting `browser.remote`

##generate Allure report:
- set `ui-tests/src/test/resources/ui_test.properties` property `logging.allure.enable=true`
- execute `./gradlew ui-tests:allureReport`
- report will be generated in `ui-tests/build/reports/allure-report`
- open `index.html` file in browser