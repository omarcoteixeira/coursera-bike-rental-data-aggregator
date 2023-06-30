.PHONY: verify
verify:
	mvn com.spotify.fmt:fmt-maven-plugin:format verify

.PHONY: format
format:
	mvn com.spotify.fmt:fmt-maven-plugin:format

.PHONY: run-local-support-servers
run-local-support-servers:
	docker-compose up -d

.PHONY: stop-local-support-servers
stop-local-support-servers:
	docker-compose down

.PHONY: run-api-server
run-api-server:
	mvn package -DskipTests=true -X -pl applications/api-server -am; \
	java -jar applications/api-server/target/api-server-*.jar

.PHONY: run-cron-server
run-cron-server:
	mvn package -DskipTests=true -X -pl applications/cron-server -am; \
	java -jar applications/cron-server/target/cron-server-*.jar

.PHONY: run-data-analyzer-server
run-data-analyzer-server:
	mvn package -DskipTests=true -X -pl applications/data-analyzer-server -am; \
	java -jar applications/data-analyzer-server/target/data-analyzer-server-*.jar