## This is a reproducer to debug how hx:vals in HTMX Spring Boot package renders null values.

- Open Street Map results is limited to the UK.
- For a residental address, search for `Number 10`.
- For a non-residential address, search for `Chatham House`, choose the one with `Chatham House (The Royal Institute of International Affairs)`.
- By default, the app is using hx:vals in `address-lookup.html` with custom Jackson Mapper for `HtmxDialect` disabled.
- When the address is selected from the results, the building name will display null in the UI.
- Comment out the `button` in `address-lookup.html`, and enable `form`.
- Search for `Number 10` again, when the address is selected, the building name will be empty in the UI.
- Uncomment `@Configuration` in `HtmxDialectConfig` class, and re-run the same test with `button` element with `hx:vals`. You might need to run `mvn clean` before loading the new configuration.
- Search for `Number 10` again, when the address is selected, the building name will be empty in the UI.
