.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build:
	make -C app build

install-dist:
	make -C app installDist

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C lint
	./gradlew checkstyleMain checkstyleTest

.PHONY: build
