## Welcome Performance Testing

This default performance test raises a set of scenarios, including: 

1. AdminScenario: two Admin users simply on-time check the home page to ensure a targeting WP site is up and running.

2. EditorScenario: [TODO] a couple of editor users add and edit post in targeting WP site during a given duration, e.g., 30 seconds (yeap, good luck for them... :-).

3. UserScenario: a number of users arrive and visit the target WP site through time, each user visits N articles by directly visiting article urls; afterward, each user searches for a key word (repeat for N times, each search against a different key word), then visits an article by visiting the article link from search result page.

#### How-to

``` ./gradlew gatlingRun ```

That's it!

Then you are running the default performance test against the default targeting Wordpress site.

#### More options

###### Data source

This performance aims at testing a wordpress site with news article extracted from HN, to prepare such a WP site, use below wp-flush app to flood news articles to your WP :-p

https://github.com/huangye177/wp-flush

###### Compiles Gatling simulation and copies resources

./gradlew gatlingClasses

###### Build project

./gradlew clean assemble

###### Run Simulation

./gradlew gatlingRun

###### Executes single Gatling simulation, SimulationFQN should be replaced by fully qualified simulation class name, by default here, it is WpSimulation

./gradlew gatlingRun-SimulationFQN